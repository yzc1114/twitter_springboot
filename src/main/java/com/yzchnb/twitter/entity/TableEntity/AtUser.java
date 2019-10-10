package com.yzchnb.twitter.entity.TableEntity;

public class AtUser extends AtUserKey {
    private Short userId;

    private String atTime;

    private Short atIsRead;

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public String getAtTime() {
        return atTime;
    }

    public void setAtTime(String atTime) {
        this.atTime = atTime == null ? null : atTime.trim();
    }

    public Short getAtIsRead() {
        return atIsRead;
    }

    public void setAtIsRead(Short atIsRead) {
        this.atIsRead = atIsRead;
    }
}