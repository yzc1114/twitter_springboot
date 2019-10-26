package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ITopicService {
    ArrayList QueryMessageByTopic(int topic_id,int start_from,int limitation);
    ArrayList QueryTopicsBaseOnHeat(int start_from,int limitation);
    void AddTopicWithMessage(String topic_content,int message_id);
    Integer GetTopicIdByName(String topic_name);
}
