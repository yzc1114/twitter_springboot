package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface IPrivateLetterService {
    void AddPrivateLetter(int sender_user_id,int receiver_user_id,String content);
    void DeletePrivateLetter(int private_letter_id);
    ArrayList QueryPrivateLetters(int user_id,int start_from,int limitation);
}
