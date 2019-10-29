package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private FuncShowMessageByRangeCaller funcShowMessageByRangeCaller;
    @Autowired
    private FuncSendMessageCaller funcSendMessageCaller;
    @Autowired
    private FuncTranspondMessageCaller funcTranspondMessageCaller;
    @Autowired
    private FuncDeleteMessageCaller funcDeleteMessageCaller;
    @Autowired
    private FuncShowFollowMessageCaller funcShowFollowMessageCaller;
    @Autowired
    private FuncShowMessageByTimeCaller funcShowMessageByTimeCaller;
    @Autowired
    private FuncAddTopicCaller funcAddTopicCaller;
    @Autowired
    private FuncAddAtUserCaller funcAddAtUserCaller;
    @Override
    public ArrayList QueryFollowMessage(int user_id, int start_from, int limitation) {
        return Utils.getMessageFromArray(funcShowFollowMessageCaller.call(user_id,start_from,limitation));
    }

    @Override
    public ArrayList QueryNewest(int start_from, int limitation) {
        return Utils.getMessageFromArray(funcShowMessageByTimeCaller.call(start_from,limitation));
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
        Integer id=funcSendMessageCaller.call(message_content,message_has_image,user_id,message_image_count);
        ArrayList<String> temps=Utils.getTopicContent(message_content);
        for(String i:temps){
            funcAddTopicCaller.call(i,id);
        }
        temps=Utils.getAtContent(message_content);
        for(String i:temps){
            funcAddAtUserCaller.call(i,id,user_id);
        }
        return id;
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
