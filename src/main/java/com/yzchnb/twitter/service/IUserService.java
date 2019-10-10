package com.yzchnb.twitter.service;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;

import java.util.ArrayList;

public interface IUserService {
    UserPublicInfo getUserPublicInfo(int userId);
    Integer signIn(String email, String password);
    void signUp(String email, String nickname, String password);
    ArrayList getRecommend();
}
