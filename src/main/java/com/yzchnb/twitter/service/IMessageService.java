package com.yzchnb.twitter.service;

import java.util.ArrayList;
import java.util.Map;

public interface IMessageService {
    Map QueryMessage(int message_id);
    ArrayList QueryUserMessage(int user_id,int start_from,int limitation);
    ArrayList QueryNewest(int start_from,int limitation);
    ArrayList QueryFollowMessage(int user_id,int start_from,int limitation);
    Integer AddMessage(String message_content  ,int message_has_image,int user_id,int message_image_count);
    Integer TransponderMessage(String message_content,int message_source_is_transponder,int message_sender_user_id,int  transponder_message_id);
    void Delete(int message_id);
}
