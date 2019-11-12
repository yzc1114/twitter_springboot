package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchMessageCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchTopicsCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchUserCaller;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.service.ISearchService;
import com.yzchnb.twitter.service.ITopicService;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

@Service
public class SearchServiceImpl implements ISearchService {
    @Autowired
    private FuncSearchMessageCaller funcSearchMessageCaller;
    @Autowired
    private FuncSearchTopicsCaller funcSearchTopicsCaller;
    @Autowired
    private FuncSearchUserCaller funcSearchUserCaller;
    @Resource
    private IUserService userService;
    @Resource
    private Utils utils;
    @Override
    public ArrayList GetTopicResults(String search_key, int start_from, int limitation) {
        return funcSearchTopicsCaller.call(search_key,start_from,limitation);
    }

    @Override
    public ArrayList GetTwitterResults(String search_key, int start_from, int limitation) {
        ArrayList<Map> ids= funcSearchMessageCaller.call(search_key,start_from,limitation);
        return utils.getMessageFromArray(ids);
    }

    @Override
    public ArrayList GetUserResults(String search_key, int start_from, int limitation) {
        ArrayList<Map> ids= funcSearchUserCaller.call(search_key,start_from,limitation);
        ArrayList<Map> result=new ArrayList<>();
        for(Map id:ids){
            result.add(userService.GetUserPublicInfo(Integer.parseInt(id.get("userId").toString())));
        }
        return result;
    }
}
