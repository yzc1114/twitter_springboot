package com.yzchnb.twitter.entity.TableEntity;

public class LikesKey {
    private Short likesUserId;

    private Short likesMessageId;

    public Short getLikesUserId() {
        return likesUserId;
    }

    public void setLikesUserId(Short likesUserId) {
        this.likesUserId = likesUserId;
    }

    public Short getLikesMessageId() {
        return likesMessageId;
    }

    public void setLikesMessageId(Short likesMessageId) {
        this.likesMessageId = likesMessageId;
    }
}