package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ILikeService {
    void AddLike(int user_id, int message_id);

    void CancelLike(int user_id, int message_id);

    ArrayList QueryLikes(int user_id, int start_from, int limitation);

    Integer IfLike(int user_id, int message_id);

}
