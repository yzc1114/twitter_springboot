package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddCollectionMapper;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeleteCollectionMapper;
import com.yzchnb.twitter.dao.FunctionMapper.FuncQueryCollectionsOfMineMapper;
import com.yzchnb.twitter.service.ICollectionService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
@Service
public class CollectionServiceImpl implements ICollectionService {
    @Autowired
    private FuncAddCollectionCaller funcAddCollectionCaller;
    @Autowired
    private FuncDeleteCollectionCaller funcDeleteCollectionCaller;
    @Autowired
    private FuncGetCollectionNumCaller funcGetCollectionNumCaller;
    @Autowired
    private FuncQueryCollectionsOfMineCaller funcQueryCollectionsOfMineCaller;
    @Autowired
    private FuncQueryIfUserCollectsCaller funcQueryIfUserCollectsCaller;
    @Override
    public ArrayList QueryCollection(int user_id, int start_from, int limitation) {
        ArrayList<Map> ids=funcQueryCollectionsOfMineCaller.call(user_id,start_from,limitation);
        return Utils.getMessageFromArray(ids);
    }

    @Override
    public Integer GetCollectionNum(int user_id) {
        return funcGetCollectionNumCaller.call(user_id);
    }

    @Override
    public Integer IfCollecting(int user_id, int message_id) {
        return funcQueryIfUserCollectsCaller.call(user_id,message_id);
    }

    @Override
    public void Add(int user_id, int be_collected_id) {
        funcAddCollectionCaller.call(user_id,be_collected_id);
    }

    @Override
    public void Delete(int user_id, int be_deleted_id) {
        funcDeleteCollectionCaller.call(user_id,be_deleted_id);
    }
}
