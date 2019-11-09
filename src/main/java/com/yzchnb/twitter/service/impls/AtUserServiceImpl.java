package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddAtUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryMessageAtUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryUnreadAtCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncShowMessageByIdCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryMessageAtUserMapper;
import com.yzchnb.twitter.service.IAtUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;
@Service
public class AtUserServiceImpl implements IAtUserService {
    @Autowired
    private FuncQueryMessageAtUserCaller funcQueryMessageAtUserCaller;
    @Autowired
    private FuncQueryUnreadAtCaller funcQueryUnreadAtCaller;
    @Autowired
    private FuncAddAtUserCaller funcAddAtUserCaller;
    @Resource
    private Utils utils;
    @Override
    public ArrayList Query(int user_id, int start_from, int limitation) {
        ArrayList<Map> message_ids=funcQueryMessageAtUserCaller.call(user_id,start_from,limitation);
        return utils.getMessageFromArray(message_ids);
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
