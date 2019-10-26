package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ICommentService {
    void Add(int id,int be_commented_id,String content);
    ArrayList QueryComments(int user_id,int start_from,int limitation);

}
