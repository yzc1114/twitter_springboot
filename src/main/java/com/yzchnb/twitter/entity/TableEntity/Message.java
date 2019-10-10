package com.yzchnb.twitter.entity.TableEntity;

public class Message {
    private Short messageId;

    private String messageContent;

    private String messageCreateTime;

    private Short messageAgreeNum;

    private Short messageTranspondedNum;

    private Short messageCommentNum;

    private Short messageViewNum;

    private Short messageHasImage;

    private Short messageSenderUserId;

    private Short messageHeat;

    public Short getMessageId() {
        return messageId;
    }

    public void setMessageId(Short messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public String getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(String messageCreateTime) {
        this.messageCreateTime = messageCreateTime == null ? null : messageCreateTime.trim();
    }

    public Short getMessageAgreeNum() {
        return messageAgreeNum;
    }

    public void setMessageAgreeNum(Short messageAgreeNum) {
        this.messageAgreeNum = messageAgreeNum;
    }

    public Short getMessageTranspondedNum() {
        return messageTranspondedNum;
    }

    public void setMessageTranspondedNum(Short messageTranspondedNum) {
        this.messageTranspondedNum = messageTranspondedNum;
    }

    public Short getMessageCommentNum() {
        return messageCommentNum;
    }

    public void setMessageCommentNum(Short messageCommentNum) {
        this.messageCommentNum = messageCommentNum;
    }

    public Short getMessageViewNum() {
        return messageViewNum;
    }

    public void setMessageViewNum(Short messageViewNum) {
        this.messageViewNum = messageViewNum;
    }

    public Short getMessageHasImage() {
        return messageHasImage;
    }

    public void setMessageHasImage(Short messageHasImage) {
        this.messageHasImage = messageHasImage;
    }

    public Short getMessageSenderUserId() {
        return messageSenderUserId;
    }

    public void setMessageSenderUserId(Short messageSenderUserId) {
        this.messageSenderUserId = messageSenderUserId;
    }

    public Short getMessageHeat() {
        return messageHeat;
    }

    public void setMessageHeat(Short messageHeat) {
        this.messageHeat = messageHeat;
    }
}