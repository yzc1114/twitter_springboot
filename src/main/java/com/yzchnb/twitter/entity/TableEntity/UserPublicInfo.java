package com.yzchnb.twitter.entity.TableEntity;

public class UserPublicInfo {
    private Short userId;

    private String userNickname;

    private String userRegisterTime;

    private String userSelfIntroduction;

    private Short userFollowersNum;

    private Short userFollowsNum;

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime == null ? null : userRegisterTime.trim();
    }

    public String getUserSelfIntroduction() {
        return userSelfIntroduction;
    }

    public void setUserSelfIntroduction(String userSelfIntroduction) {
        this.userSelfIntroduction = userSelfIntroduction == null ? null : userSelfIntroduction.trim();
    }

    public Short getUserFollowersNum() {
        return userFollowersNum;
    }

    public void setUserFollowersNum(Short userFollowersNum) {
        this.userFollowersNum = userFollowersNum;
    }

    public Short getUserFollowsNum() {
        return userFollowsNum;
    }

    public void setUserFollowsNum(Short userFollowsNum) {
        this.userFollowsNum = userFollowsNum;
    }
}