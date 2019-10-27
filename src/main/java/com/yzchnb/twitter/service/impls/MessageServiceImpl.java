package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class MessageServiceImpl implements IMessageService {

    @Override
    public ArrayList QueryFollowMessage(int user_id, int start_from, int limitation) {
        return null;
    }

    @Override
    public ArrayList QueryNewest(int start_from, int limitation) {
        return null;
    }

    @Override
    public ArrayList QueryUserMessage(int user_id, int start_from, int limitation) {
        return null;
    }

    @Override
    public Integer AddMessage(String message_content, int message_has_image, int user_id, int message_image_count) {
        return null;
    }

    @Override
    public Integer TransponderMessage(String message_content, int message_source_is_transponder, int message_sender_user_id, int transponder_message_id) {
        return null;
    }

    @Override
    public Map QueryMessage(int message_id) {
        return null;
    }

    @Override
    public void Delete(int message_id) {

    }
}
