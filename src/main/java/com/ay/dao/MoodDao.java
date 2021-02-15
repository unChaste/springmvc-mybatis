package com.ay.dao;

import com.ay.model.UserMoodPraise;
import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.response.MoodListResponse;

import java.util.List;

public interface MoodDao {
    List<MoodListResponse> listMood(MoodListRequest request);

    int saveUserMoodPraise(UserMoodPraise userMoodPraise);

    int increasePraiseNum(Integer moodId);

    UserMoodPraise findPraiseByMoodIdAndUserId(MoodPraiseRequest request);

    int deleteUserMoodPraiseById(Integer userMoodPraiseId);

    int decreasePraiseNum(Integer moodId);
}

