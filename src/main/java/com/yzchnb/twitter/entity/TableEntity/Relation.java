package com.yzchnb.twitter.entity.TableEntity;

public class Relation extends RelationKey {
    private String relationCreateTime;

    public String getRelationCreateTime() {
        return relationCreateTime;
    }

    public void setRelationCreateTime(String relationCreateTime) {
        this.relationCreateTime = relationCreateTime == null ? null : relationCreateTime.trim();
    }
}