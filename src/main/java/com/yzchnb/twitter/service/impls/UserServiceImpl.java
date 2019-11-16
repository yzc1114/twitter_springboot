package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
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
    private FuncCheckUserinfoExistCaller funcCheckUserinfoExistCaller;
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

    public void SignUp(String email, String nickname, String password) throws UserException {
        System.out.println("preparing signUp email:" + email + " nickname: " + nickname + " password: " + password);
        int exist = funcCheckUserinfoExistCaller.call(email, nickname);
        if(exist == 1){
            throw new UserException("userinfo exists");
        }
        funcUserSignUpCaller.call(email, nickname, password);
    }

    public Integer SignIn(String email, String password) {
        System.out.println("sign up " + email);
        return funcUserSignInByEmailCaller.call(email, password);
    }

    public ArrayList GetRecommend(){
        ArrayList<Map> result = funcRecommendUserCaller.call();
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
        System.out.println("nickname:  " + userInfoEdit.getNickname() + "  password:  " + userInfoEdit.getPassword()
                            + "  realName: " + userInfoEdit.getRealName() + "  gender:  "+ userInfoEdit.getGender()
                            + "   selfIntroduction:  "+ userInfoEdit.getSelfIntroduction());
        if(!userInfoEdit.getNickname().equals("")) mode |= 1 << 0;
        if (!userInfoEdit.getSelfIntroduction().equals("")) mode |= 1 << 1;
        if (!userInfoEdit.getPassword().equals("")) mode |= 1 << 2;
        if (!userInfoEdit.getRealName().equals("")) mode |= 1 << 3;
        if (!userInfoEdit.getGender().equals("")) mode |= 1 << 4;
        funcSetUserInfoCaller.call(userInfoEdit.getNickname(),userInfoEdit.getSelfIntroduction(),userInfoEdit.getPassword(),
                userInfoEdit.getRealName(),userInfoEdit.getGender(),userId,mode);
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
