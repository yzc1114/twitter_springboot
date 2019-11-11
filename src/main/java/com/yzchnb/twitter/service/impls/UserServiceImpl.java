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

    @Resource
    private FuncGetUserPublicInfoCaller funcGetUserPublicInfoCaller;
    @Resource
    private FuncUserSignUpCaller funcUserSignUpCaller;
    @Resource
    private FuncUserSignInByEmailCaller funcUserSignInByEmailCaller;
    @Resource
    private FuncRecommendUserCaller funcRecommendUserCaller;
    @Resource
    private FuncCheckUserEmailExistCaller funcCheckUserEmailExistCaller;
    @Resource
    private FuncGetMessageNumCaller funcGetMessageNumCaller;
    @Resource
    private FuncGetUserPrivateInfoCaller funcGetUserPrivateInfoCaller;
    @Resource
    private FuncSetUserInfoCaller funcSetUserInfoCaller;
    @Resource
    private FuncGetCollectionNumCaller funcGetCollectionNumCaller;
    @Resource
    private Utils utils;
    public Map GetUserPublicInfo(int userId){
        System.out.println(userId);
        Map result=(Map)funcGetUserPublicInfoCaller.call(userId).get(0);
        utils.setAvatarUrl(result);
        result.put("userMessagesNum",GetUserMessageNum(userId));
        result.put("userCollectionsNum",funcGetCollectionNumCaller.call(userId));
        return result;
    }

    public void SignUp(String email, String nickname, String password){
        System.out.println("preparing signUp email:" + email + " nickname: " + nickname + " password: " + password);
        funcUserSignUpCaller.call(email, nickname, password);
    }

    public Integer SignIn(String email, String password) {
        System.out.println("sign up " + email);
        return funcUserSignInByEmailCaller.call(email, password);
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
    public void EditInfo(UserInfoEdit userInfoEdit, int userId) {
        int mode = 0;
        System.out.println("nickname:  " + userInfoEdit.nickname + "  password:  " + userInfoEdit.password
                            + "  realName: " + userInfoEdit.realName + "  gender:  "+ userInfoEdit.gender
                            + "   selfIntroduction:  "+ userInfoEdit.selfIntroduction);
        if(!userInfoEdit.nickname.equals("")) mode |= 1 << 0;
        if (!userInfoEdit.selfIntroduction.equals("")) mode |= 1 << 1;
        if (!userInfoEdit.password.equals("")) mode |= 1 << 2;
        if (!userInfoEdit.realName.equals("")) mode |= 1 << 3;
        if (!userInfoEdit.gender.equals("")) mode |= 1 << 4;
        funcSetUserInfoCaller.call(userInfoEdit.nickname,userInfoEdit.selfIntroduction,userInfoEdit.password,
                userInfoEdit.realName,userInfoEdit.gender,userId,mode);
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
