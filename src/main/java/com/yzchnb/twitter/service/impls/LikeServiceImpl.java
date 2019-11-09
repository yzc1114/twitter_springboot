package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.service.ILikeService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    private FuncQueryUserLikesMessageCaller funcQueryUserLikesMessageCaller;
    @Autowired
    private FuncAddLikeCaller funcAddLikeCaller;
    @Autowired
    private FuncDeleteLikeCaller funcDeleteLikeCaller;
    @Autowired
    private FuncQueryMessageIdsLikesCaller funcQueryMessageIdsLikesCaller;
    @Resource
    private Utils utils;

    @Override
    public ArrayList QueryLikes(int user_id, int start_from, int limitation) {
        return utils.getMessageFromArray(funcQueryMessageIdsLikesCaller.call(user_id,start_from,limitation));
    }

    @Override
    public Integer IfLike(int user_id, int message_id) {
        return funcQueryUserLikesMessageCaller.call(user_id,message_id);
    }

    @Override
    public void AddLike(int user_id, int message_id) {
        funcAddLikeCaller.call(user_id,message_id);
    }

    @Override
    public void CancelLike(int user_id, int message_id) {
        funcDeleteLikeCaller.call(user_id,message_id);
    }
}
