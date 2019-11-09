package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.dao.TableMapper.UserPrivateInfoMapper;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.entity.entityforController.UserEntity.UserInfoEdit;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Autowired
    private FuncCheckUserEmailExistCaller funcCheckUserEmailExistCaller;
    @Autowired
    private FuncGetMessageNumCaller funcGetMessageNumCaller;
    @Autowired
    private FuncGetUserPrivateInfoCaller funcGetUserPrivateInfoCaller;
    @Resource
    private Utils utils;
    public Map GetUserPublicInfo(int userId){
        System.out.println(userId);
        Map result=(Map)funcGetUserPublicInfoCaller.call(userId).get(0);
        utils.setAvatarUrl(result);
        return result;
    }

    public void SignUp(String email, String nickname, String password){
        System.out.println("preparing signUp email:" + email + " nickname: " + nickname + " password: " + password);
        funcUserSignUpCaller.call(email, nickname, password);
    }

    public Integer SignIn(String email, String password) {
        System.out.println("sign up " + email);
        Integer userId = funcUserSignInByEmailCaller.call(email, password);
        return userId;
    }

    public ArrayList GetRecommend(){
        ArrayList<Map> result=funcRecommendUserCaller.call();
        for(Map user:result){
            utils.setAvatarUrl(user);
        }
        return result;
    }

    @Override
    public Integer CheckUserEmail(String email) {
        return funcCheckUserEmailExistCaller.call(email);
    }

    @Override
    public Integer GetUserMessageNum(int user_id) {
        return funcGetMessageNumCaller.call(user_id);
    }

    @Override
    public void EditInfo(UserInfoEdit userInfoEdit) {

    }

    @Override
    public Map GetAllInfo(int user_id) {
        Map result=GetUserPublicInfo(user_id);
        Map<String,Object> temp=(Map<String,Object>)funcGetUserPrivateInfoCaller.call(user_id).get(0);
        for(String key:temp.keySet()){
            result.put(key,temp.get(key));
        }
        return result;
    }


}
