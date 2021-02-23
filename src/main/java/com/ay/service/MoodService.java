package com.ay.service;

import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.response.MoodListResponse;

import java.util.List;
import java.util.Set;

public interface MoodService {
    List<MoodListResponse> listMood(MoodListRequest request);

    boolean praise(MoodPraiseRequest request);

    boolean unpraise(MoodUnpraiseRequest request);

    int savePraiseList(Integer moodId, Set<Integer> praiseUserIdSet);

    int deletePraiseList(Integer moodId, Set<Integer> unpraiseUserIdSet);

    void asyncPraise(MoodPraiseRequest request);

    void asyncUnpraise(MoodUnpraiseRequest request);
}
