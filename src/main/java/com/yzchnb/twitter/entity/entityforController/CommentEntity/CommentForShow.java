package com.yzchnb.twitter.entity.entityforController.CommentEntity;

import com.yzchnb.twitter.entity.TableEntity.CommentOnMessage;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;

public class CommentForShow {
    private UserPublicInfo userPublicInfo;
    private CommentOnMessage commentOnMessage;

    public UserPublicInfo getUserPublicInfo() {
        return userPublicInfo;
    }

    public void setUserPublicInfo(UserPublicInfo userPublicInfo) {
        this.userPublicInfo = userPublicInfo;
    }

    public CommentOnMessage getCommentOnMessage() {
        return commentOnMessage;
    }

    public void setCommentOnMessage(CommentOnMessage commentOnMessage) {
        this.commentOnMessage = commentOnMessage;
    }
}
