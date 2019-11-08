package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.AddAvatarCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncGetUserAvatarCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSetMainAvatarCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncSetMainAvatarMapper;
import com.yzchnb.twitter.service.IAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarServiceImpl implements IAvatarService {
    @Autowired
    private FuncSetMainAvatarCaller funcSetMainAvatarCaller;
    @Autowired
    private FuncGetUserAvatarCaller funcGetUserAvatarCaller;
    @Autowired
    private AddAvatarCaller addAvatarCaller;
    @Override
    public void SetMainAvatar(int user_id, int avatar_id) {
        funcSetMainAvatarCaller.call(user_id,avatar_id);
    }

    @Override
    public Integer AddAvatar(int user_id) {
        return addAvatarCaller.call(user_id);
    }

    @Override
    public Integer GetMainAvatar(int user_id) {
        return funcGetUserAvatarCaller.call(user_id);
    }
}
