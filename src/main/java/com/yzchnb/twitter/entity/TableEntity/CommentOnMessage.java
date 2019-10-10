package com.yzchnb.twitter.entity.TableEntity;

public class CommentOnMessage {
    private Short commentId;

    private String commentContent;

    private Short commentIsRead;

    private Short commentSenderId;

    private Short commentMessageId;

    private String commentCreateTime;

    public Short getCommentId() {
        return commentId;
    }

    public void setCommentId(Short commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Short getCommentIsRead() {
        return commentIsRead;
    }

    public void setCommentIsRead(Short commentIsRead) {
        this.commentIsRead = commentIsRead;
    }

    public Short getCommentSenderId() {
        return commentSenderId;
    }

    public void setCommentSenderId(Short commentSenderId) {
        this.commentSenderId = commentSenderId;
    }

    public Short getCommentMessageId() {
        return commentMessageId;
    }

    public void setCommentMessageId(Short commentMessageId) {
        this.commentMessageId = commentMessageId;
    }

    public String getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(String commentCreateTime) {
        this.commentCreateTime = commentCreateTime == null ? null : commentCreateTime.trim();
    }
}