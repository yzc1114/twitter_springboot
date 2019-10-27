package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncDeleteMessageCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSendMessageCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByRangeCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncTranspondMessageCaller;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class MessageServiceImpl implements IMessageService {
    @Autowired
    private FuncShowMessageByRangeCaller funcShowMessageByRangeCaller;
    @Autowired
    private FuncSendMessageCaller funcSendMessageCaller;
    @Autowired
    private FuncTranspondMessageCaller funcTranspondMessageCaller;
    @Autowired
    private FuncDeleteMessageCaller funcDeleteMessageCaller;
    @Override
    public ArrayList QueryFollowMessage(int user_id, int start_from, int limitation) {
        return 1;
    }

    @Override
    public ArrayList QueryNewest(int start_from, int limitation) {
        return null;
    }

    @Override
    public ArrayList QueryUserMessage(int user_id, int start_from, int limitation) {
        ArrayList<Map> result=funcShowMessageByRangeCaller.call(user_id,start_from,limitation);
        for(Map message : result){
            Utils.setMessageUrl(message);
        }
        return result;
    }

    @Override
    public Integer AddMessage(String message_content, int message_has_image, int user_id, int message_image_count) {
        return funcSendMessageCaller.call(message_content,message_has_image,user_id,message_image_count);
    }

    @Override
    public Integer TransponderMessage(String message_content, int message_source_is_transponder, int message_sender_user_id, int transponder_message_id) {
        return funcTranspondMessageCaller.call(message_content,message_source_is_transponder,
                message_sender_user_id,transponder_message_id);
    }

    @Override
    public Map QueryMessage(int message_id) {
        return Utils.getMessageById(message_id);
    }

    @Override
    public void Delete(int message_id) {
        funcDeleteMessageCaller.call(message_id);
    }
}
