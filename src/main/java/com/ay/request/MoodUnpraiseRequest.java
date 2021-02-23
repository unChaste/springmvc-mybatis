package com.ay.request;

import java.io.Serializable;

public class MoodUnpraiseRequest implements Serializable {
    private Integer moodId;
    private Integer userId;

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MoodUnpraiseRequest{" +
                "moodId=" + moodId +
                ", userId=" + userId +
                '}';
    }
}
