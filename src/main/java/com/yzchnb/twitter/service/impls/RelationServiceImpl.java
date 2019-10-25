package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class RelationServiceImpl implements IRelationService {
    @Autowired
    private FuncQueryFollowersListCaller funcQueryFollowersListCaller;
    @Autowired
    private FuncQueryFollowingListCaller funcQueryFollowingListCaller;
    @Autowired
    private FuncAddRelationCaller funcAddRelationCaller;
    @Autowired
    private FuncRemoveRelationCaller funcRemoveRelationCaller;
    @Autowired
    private FuncIfFollowingCaller funcIfFollowingCaller;
    @Override
    public ArrayList QueryFollowersFor(int user_id, int start_from, int limitation) {
        return funcQueryFollowersListCaller.call(user_id,start_from,limitation);
    }

    @Override
    public ArrayList QueryFollowingFor(int user_id, int start_from, int limitation) {
        return funcQueryFollowingListCaller.call(user_id,start_from,limitation);
    }

    @Override
    public void CancelFollowingTo(int follower_id, int be_followed_id) {
        funcRemoveRelationCaller.call(follower_id,be_followed_id);
    }

    @Override
    public void FollowUser(int follower_id, int be_followed_id) {
        funcAddRelationCaller.call(follower_id,be_followed_id);
    }

    @Override
    public void IfFollowing(int follower_id, int be_followed_id) {
        funcIfFollowingCaller.call(follower_id,be_followed_id);
    }
}
