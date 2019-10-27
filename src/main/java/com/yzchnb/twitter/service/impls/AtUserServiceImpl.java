package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddAtUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryMessageAtUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryUnreadAtCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByIdCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryMessageAtUserMapper;
import com.yzchnb.twitter.service.IAtUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class AtUserServiceImpl implements IAtUserService {
    @Autowired
    private FuncQueryMessageAtUserCaller funcQueryMessageAtUserCaller;
    @Autowired
    private FuncQueryUnreadAtCaller funcQueryUnreadAtCaller;
    @Autowired
    private FuncAddAtUserCaller funcAddAtUserCaller;
    @Override
    public ArrayList Query(int user_id, int start_from, int limitation) {
        ArrayList message_ids=funcQueryMessageAtUserCaller.call(user_id,start_from,limitation);
        ArrayList<Map> messages=new ArrayList<>();
        for(Map i:(ArrayList<Map>)message_ids){
            messages.add(Utils.getMessageById(Integer.parseInt(i.get("message_id").toString())));
        }
        return messages;
    }

    @Override
    public Integer QueryUnreadAt(int user_id) {
        return funcQueryUnreadAtCaller.call(user_id);
    }

    @Override
    public void AddUserAt(String nickname, int source_message_id, int source_user_id) {
        funcAddAtUserCaller.call(nickname,source_message_id,source_user_id);
    }
}
