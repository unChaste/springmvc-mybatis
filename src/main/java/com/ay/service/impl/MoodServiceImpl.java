package com.ay.service.impl;

import com.ay.dao.MoodDao;
import com.ay.jms.MoodProducer;
import com.ay.model.UserMoodPraise;
import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.response.MoodListResponse;
import com.ay.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
@Service
public class MoodServiceImpl implements MoodService {
    public static final String REIDS_PRAISE_MOOD_ID_SET = "praise.mood.id.set";
    public static final String REIDS_PRAISE_PREFIX = "praise:";
    public static final String REIDS_UNPRAISE_PREFIX = "unpraise:";

    @Autowired
    private MoodDao moodDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<MoodListResponse> listMood(MoodListRequest request) {
        List<MoodListResponse> moodList = moodDao.listMood(request);
        updatePraiseStatus(moodList, request.getUserId());
        return moodList;
    }

    private void updatePraiseStatus(List<MoodListResponse> moodList, Integer userId) {
        for (MoodListResponse response : moodList) {
            boolean isMemberOfPraiseGroud = redisTemplate.opsForSet().isMember(REIDS_PRAISE_PREFIX + response.getId(), userId);
            boolean isMemberOfUnpraiseGroup = redisTemplate.opsForSet().isMember(REIDS_UNPRAISE_PREFIX + response.getId(), userId);
            if (isMemberOfPraiseGroud) {
                response.setHasPraised(true);
            } else if (isMemberOfUnpraiseGroup) {
                response.setHasPraised(false);
            }
            Long praiseNumOfRedis = redisTemplate.opsForSet().size(REIDS_PRAISE_PREFIX + response.getId());
            Long unpraiseNumOfRedis = redisTemplate.opsForSet().size(REIDS_UNPRAISE_PREFIX + response.getId());
            response.setPraiseNum(response.getPraiseNum() + praiseNumOfRedis.intValue() - unpraiseNumOfRedis.intValue());
        }
    }

    @Autowired
    private MoodProducer moodProducer;

    public void asyncPraise(MoodPraiseRequest request) {
        moodProducer.sendPraiseMessage(request);
    }

    @Override
    public void asyncUnpraise(MoodUnpraiseRequest request) {
        moodProducer.sendUnpraiseMessage(request);
    }

    @Override
    public boolean praise(MoodPraiseRequest request) {
        redisTemplate.opsForSet().remove(REIDS_UNPRAISE_PREFIX + request.getMoodId(), request.getUserId());
        UserMoodPraise userMoodPraise = moodDao.findPraiseByMoodIdAndUserId(request);
        if (userMoodPraise == null) {
            redisTemplate.opsForSet().add(REIDS_PRAISE_PREFIX + request.getMoodId(), request.getUserId());
            redisTemplate.opsForSet().add(REIDS_PRAISE_MOOD_ID_SET, request.getMoodId());
        }
        return true;
    }

    @Override
    public boolean unpraise(MoodUnpraiseRequest request) {
        redisTemplate.opsForSet().remove(REIDS_PRAISE_PREFIX + request.getMoodId(), request.getUserId());
        redisTemplate.opsForSet().add(REIDS_UNPRAISE_PREFIX + request.getMoodId(), request.getUserId());
        redisTemplate.opsForSet().add(REIDS_PRAISE_MOOD_ID_SET, request.getMoodId());
        return true;
    }

    @Override
    public int savePraiseList(Integer moodId, Set<Integer> praiseUserIdSet) {
        int row = moodDao.savePraiseList(moodId, praiseUserIdSet);
        return row;
    }

    @Override
    public int deletePraiseList(Integer moodId, Set<Integer> unpraiseUserIdSet) {
        int row = moodDao.deletePraiseList(moodId, unpraiseUserIdSet);
        return row;
    }
}
