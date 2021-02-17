package com.ay.dao;

import com.ay.model.UserMoodPraise;
import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.response.MoodListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface MoodDao {
    List<MoodListResponse> listMood(MoodListRequest request);

    int saveUserMoodPraise(UserMoodPraise userMoodPraise);

    int increasePraiseNum(Integer moodId);

    UserMoodPraise findPraiseByMoodIdAndUserId(MoodPraiseRequest request);

    int deleteUserMoodPraiseById(Integer userMoodPraiseId);

    int decreasePraiseNum(Integer moodId);

    int savePraiseList(@Param("moodId") Integer moodId, @Param("praiseUserIdSet") Set<Integer> praiseUserIdSet);

    int deletePraiseList(@Param("moodId") Integer moodId, @Param("unpraiseUserIdSet") Set<Integer> unpraiseUserIdSet);
}

