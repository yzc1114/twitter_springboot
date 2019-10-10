package com.yzchnb.twitter.entity.TableEntity;

public class Likes extends LikesKey {
    private String likesTime;

    public String getLikesTime() {
        return likesTime;
    }

    public void setLikesTime(String likesTime) {
        this.likesTime = likesTime == null ? null : likesTime.trim();
    }
}