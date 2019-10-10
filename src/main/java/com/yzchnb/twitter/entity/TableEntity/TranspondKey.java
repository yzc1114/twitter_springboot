package com.yzchnb.twitter.entity.TableEntity;

public class TranspondKey {
    private Short messageId;

    private Short transpondedMessageId;

    public Short getMessageId() {
        return messageId;
    }

    public void setMessageId(Short messageId) {
        this.messageId = messageId;
    }

    public Short getTranspondedMessageId() {
        return transpondedMessageId;
    }

    public void setTranspondedMessageId(Short transpondedMessageId) {
        this.transpondedMessageId = transpondedMessageId;
    }
}