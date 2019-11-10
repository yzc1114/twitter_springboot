package com.yzchnb.twitter.service;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.entity.entityforController.UserEntity.UserInfoEdit;

import java.util.ArrayList;
import java.util.Map;

public interface IUserService {
    Map GetUserPublicInfo(int userId);
    Integer SignIn(String email, String password);
    void SignUp(String email, String nickname, String password);
    ArrayList GetRecommend();
    Map GetAllInfo(int user_id);
    Integer CheckUserEmail(String email);
    Integer GetUserMessageNum(int user_id);
    void EditInfo(UserInfoEdit userInfoEdit, int userId);
}
