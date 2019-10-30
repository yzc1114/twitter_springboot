package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ICommentService {
    void AddComment(int user_id,int be_commented_id,String content);
    ArrayList QueryComments(int message_id,int start_from,int limitation);

}
