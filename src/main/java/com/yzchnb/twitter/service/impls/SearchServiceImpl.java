package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchMessageCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchTopicsCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncSearchUserCaller;
import com.yzchnb.twitter.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class SearchServiceImpl implements ISearchService {
    @Autowired
    private FuncSearchMessageCaller funcSearchMessageCaller;
    @Autowired
    private FuncSearchTopicsCaller funcSearchTopicsCaller;
    @Autowired
    private FuncSearchUserCaller funcSearchUserCaller;
    @Override
    public ArrayList GetTopicResults(String search_key, int start_from, int limitation) {
        return funcSearchTopicsCaller.call(search_key,start_from,limitation);
    }

    @Override
    public ArrayList GetTwitterResults(String search_key, int start_from, int limitation) {
        return funcSearchMessageCaller.call(search_key,start_from,limitation);
    }

    @Override
    public ArrayList GetUserResults(String search_key, int start_from, int limitation) {
        return funcSearchUserCaller.call(search_key,start_from,limitation);
    }
}
