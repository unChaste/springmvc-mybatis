package com.ay.response;

import java.util.Date;

public class MoodListResponse {
    private Integer id;
    private Integer userId;
    private String userName;
    private String content;
    private Date publishTime;
    private Integer praiseNum;
    private Boolean hasPraised;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Boolean getHasPraised() {
        return hasPraised;
    }

    public void setHasPraised(Boolean hasPraised) {
        this.hasPraised = hasPraised;
    }
}
