package com.yzchnb.twitter.service;

public interface IAvatarService {
    void SetMainAvatar(int user_id,int avatar_id);
    Integer GetMainAvatar(int user_id);
    Integer AddAvatar(int user_id);
}
