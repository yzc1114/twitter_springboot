package com.yzchnb.twitter.entity.TableEntity;

public class PrivateLetter {
    private Short privateLetterId;

    private String privateLetterContent;

    private Short privateLetterIsRead;

    private String privateLetterCreateTime;

    private Short privateLetterSenderId;

    private Short privateLetterReceiverId;

    public Short getPrivateLetterId() {
        return privateLetterId;
    }

    public void setPrivateLetterId(Short privateLetterId) {
        this.privateLetterId = privateLetterId;
    }

    public String getPrivateLetterContent() {
        return privateLetterContent;
    }

    public void setPrivateLetterContent(String privateLetterContent) {
        this.privateLetterContent = privateLetterContent == null ? null : privateLetterContent.trim();
    }

    public Short getPrivateLetterIsRead() {
        return privateLetterIsRead;
    }

    public void setPrivateLetterIsRead(Short privateLetterIsRead) {
        this.privateLetterIsRead = privateLetterIsRead;
    }

    public String getPrivateLetterCreateTime() {
        return privateLetterCreateTime;
    }

    public void setPrivateLetterCreateTime(String privateLetterCreateTime) {
        this.privateLetterCreateTime = privateLetterCreateTime == null ? null : privateLetterCreateTime.trim();
    }

    public Short getPrivateLetterSenderId() {
        return privateLetterSenderId;
    }

    public void setPrivateLetterSenderId(Short privateLetterSenderId) {
        this.privateLetterSenderId = privateLetterSenderId;
    }

    public Short getPrivateLetterReceiverId() {
        return privateLetterReceiverId;
    }

    public void setPrivateLetterReceiverId(Short privateLetterReceiverId) {
        this.privateLetterReceiverId = privateLetterReceiverId;
    }
}