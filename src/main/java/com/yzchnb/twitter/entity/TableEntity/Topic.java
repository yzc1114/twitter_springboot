package com.yzchnb.twitter.entity.TableEntity;

public class Topic {
    private Short topicId;

    private Short topicHeat;

    private String topicContent;

    public Short getTopicId() {
        return topicId;
    }

    public void setTopicId(Short topicId) {
        this.topicId = topicId;
    }

    public Short getTopicHeat() {
        return topicHeat;
    }

    public void setTopicHeat(Short topicHeat) {
        this.topicHeat = topicHeat;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }
}