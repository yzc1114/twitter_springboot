package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncGetUserPublicInfoCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncRecommendUserCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignInByEmailCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncUserSignUpCaller;
import com.yzchnb.twitter.dao.TableMapper.UserPrivateInfoMapper;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private FuncGetUserPublicInfoCaller funcGetUserPublicInfoCaller;
    @Autowired
    private FuncUserSignUpCaller funcUserSignUpCaller;
    @Autowired
    private FuncUserSignInByEmailCaller funcUserSignInByEmailCaller;
    @Autowired
    private FuncRecommendUserCaller funcRecommendUserCaller;

    public Map getUserPublicInfo(int userId){
        System.out.println(userId);
        Map result=(Map)funcGetUserPublicInfoCaller.call(userId).get(0);
        Utils.setAvatarUrl(result);
        return result;
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
        ArrayList<Map> result=funcRecommendUserCaller.call();
        for(Map user:result){
            Utils.setAvatarUrl(user);
        }
        return result;
    }

}
