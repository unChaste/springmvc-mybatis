package com.ay.web;

import com.ay.service.MoodService;
import com.ay.service.impl.MoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;


@Configuration
@EnableScheduling
public class PraiseDataSaveToDBJob {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MoodService moodService;

    @Scheduled(cron = "*/30 * * * * *")
    public void savePraiseDataToDB() {
        Set<Integer> moodIdSet = redisTemplate.opsForSet().members(MoodServiceImpl.REIDS_PRAISE_MOOD_ID_SET);
        redisTemplate.delete(MoodServiceImpl.REIDS_PRAISE_MOOD_ID_SET);
        for (Integer moodId : moodIdSet) {
            Set<Integer> praiseUserIdSet = redisTemplate.opsForSet().members(MoodServiceImpl.REIDS_PRAISE_PREFIX + moodId);
            redisTemplate.delete(MoodServiceImpl.REIDS_PRAISE_PREFIX + moodId);
            if (!praiseUserIdSet.isEmpty()) {
                moodService.savePraiseList(moodId, praiseUserIdSet);
            }

            Set<Integer> unpraiseUserIdSet = redisTemplate.opsForSet().members(MoodServiceImpl.REIDS_UNPRAISE_PREFIX + moodId);
            redisTemplate.delete(MoodServiceImpl.REIDS_UNPRAISE_PREFIX + moodId);
            if (!unpraiseUserIdSet.isEmpty()) {
                moodService.deletePraiseList(moodId, unpraiseUserIdSet);
            }
        }
    }
}
