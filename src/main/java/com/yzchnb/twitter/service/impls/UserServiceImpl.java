package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncRecommendUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignInByEmailCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignUpCaller;
import com.yzchnb.twitter.dao.TableMapper.UserPrivateInfoMapper;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserPublicInfoMapper userPublicInfoMapper;
    @Autowired
    private FuncUserSignUpCaller funcUserSignUpCaller;
    @Autowired
    private FuncUserSignInByEmailCaller funcUserSignInByEmailCaller;
    @Autowired
    private FuncRecommendUserCaller funcRecommendUserCaller;

    public UserPublicInfo getUserPublicInfo(int userId){
        System.out.println(userPublicInfoMapper);
        System.out.println(userId);
        return userPublicInfoMapper.selectByPrimaryKey((short)userId);
    }

    public void signUp(String email, String nickname, String password){
        System.out.println("preparing signUp email:" + email + " nickname: " + nickname + " password: " + password);
        funcUserSignUpCaller.call(email, nickname, password);
    }

    public Integer signIn(String email, String password) {
        System.out.println("sign up " + email);
        Integer userId = funcUserSignInByEmailCaller.call(email, password);
        return userId;
    }

    public ArrayList getRecommend(){
        return funcRecommendUserCaller.call();
    }

}
