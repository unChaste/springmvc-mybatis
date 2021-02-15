package com.ay.service;

import com.ay.request.MoodListRequest;
import com.ay.request.MoodPraiseRequest;
import com.ay.request.MoodUnpraiseRequest;
import com.ay.response.MoodListResponse;

import java.util.List;

public interface MoodService {
    List<MoodListResponse> listMood(MoodListRequest request);

    boolean praise(MoodPraiseRequest request);

    boolean unpraise(MoodUnpraiseRequest request);
}
