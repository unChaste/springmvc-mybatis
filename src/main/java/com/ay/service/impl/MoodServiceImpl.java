package com.ay.service.impl;

import com.ay.dao.MoodDao;
import com.ay.model.UserMoodPraise;
import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.response.MoodListResponse;
import com.ay.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    @Autowired
    private MoodDao moodDao;

    @Override
    public List<MoodListResponse> listMood(MoodListRequest request) {
        List<MoodListResponse> moodList = moodDao.listMood(request);
        return moodList;
    }

    @Override
    public boolean praise(MoodPraiseRequest request) {
        UserMoodPraise userMoodPraise = moodDao.findPraiseByMoodIdAndUserId(request);
        if (userMoodPraise != null) {
            return false;
        }
        userMoodPraise = new UserMoodPraise();
        userMoodPraise.setMoodId(request.getMoodId());
        userMoodPraise.setUserId(request.getUserId());
        userMoodPraise.setCancel(false);
        userMoodPraise.setPraiseTime(new Date());
        int row = moodDao.saveUserMoodPraise(userMoodPraise);
        boolean success = row == 1 ? true : false;
        if (success) {
            moodDao.increasePraiseNum(request.getMoodId());
        }
        return success;
    }

    @Override
    public boolean unpraise(MoodUnpraiseRequest request) {
        MoodPraiseRequest moodPraiseRequest = new MoodPraiseRequest();
        moodPraiseRequest.setMoodId(request.getMoodId());
        moodPraiseRequest.setUserId(request.getUserId());
        UserMoodPraise userMoodPraise = moodDao.findPraiseByMoodIdAndUserId(moodPraiseRequest);
        if (userMoodPraise == null) {
            return false;
        }
        int row = moodDao.deleteUserMoodPraiseById(userMoodPraise.getId());
        boolean success = row == 1 ? true : false;
        if (success) {
            moodDao.decreasePraiseNum(request.getMoodId());
        }
        return success;
    }
}
