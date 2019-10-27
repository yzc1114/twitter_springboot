package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddCommentCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryCommentByRangeCaller;
import com.yzchnb.twitter.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private FuncAddCommentCaller funcAddCommentCaller;
    @Autowired
    private FuncQueryCommentByRangeCaller funcQueryCommentByRangeCaller;
    @Override
    public ArrayList QueryComments(int message_id, int start_from, int limitation) {
        return funcQueryCommentByRangeCaller.call(message_id,start_from,limitation);
    }

    @Override
    public void Add(int user_id, int be_commented_id, String content) {
        funcAddCommentCaller.call(user_id,be_commented_id,content);
    }
}
