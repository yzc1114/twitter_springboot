package com.yzchnb.twitter.service;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;

import java.util.ArrayList;

public interface IRelationService {
    ArrayList QueryFollowersFor(int user_id,int start_from,int limitation);
    ArrayList QueryFollowingFor(int user_id,int start_from,int limitation);
    void FollowUser(int follower_id,int be_followed_id);
    void CancelFollowingTo(int follower_id,int be_followed_id);
    void IfFollowing(int follower_id,int be_followed_id);
}
