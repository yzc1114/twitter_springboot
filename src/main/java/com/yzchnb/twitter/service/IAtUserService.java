package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface IAtUserService {
    ArrayList Query(int user_id,int start_from,int limitation);
    Integer QueryUnreadAt(int user_id);
    void AddUserAt(String nickname,int source_message_id,int source_user_id);
}
