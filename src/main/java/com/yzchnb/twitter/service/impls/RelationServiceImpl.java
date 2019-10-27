package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.service.IRelationService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public ArrayList<Map> QueryFollowersFor(int user_id, int start_from, int limitation) {
        ArrayList<Map> result= funcQueryFollowersListCaller.call(user_id,start_from,limitation);
        for(Map map : result){
            Utils.setAvatarUrl(map);
        }
        return result;
    }

    @Override
    public ArrayList<Map> QueryFollowingFor(int user_id, int start_from, int limitation) {
        ArrayList<Map> result = funcQueryFollowingListCaller.call(user_id,start_from,limitation);
        for(Map map : result){
            Utils.setAvatarUrl(map);
        }
        return result;
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
    public Integer IfFollowing(int follower_id, int be_followed_id) {
        return funcIfFollowingCaller.call(follower_id,be_followed_id);
    }
}
