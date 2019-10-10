package com.yzchnb.twitter.entity.TableEntity;

public class RelationKey {
    private Short relationUserFollowerId;

    private Short relationUserBeFollowedId;

    public Short getRelationUserFollowerId() {
        return relationUserFollowerId;
    }

    public void setRelationUserFollowerId(Short relationUserFollowerId) {
        this.relationUserFollowerId = relationUserFollowerId;
    }

    public Short getRelationUserBeFollowedId() {
        return relationUserBeFollowedId;
    }

    public void setRelationUserBeFollowedId(Short relationUserBeFollowedId) {
        this.relationUserBeFollowedId = relationUserBeFollowedId;
    }
}