package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddCommentCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryCommentByRangeCaller;
import com.yzchnb.twitter.service.ICommentService;
import com.yzchnb.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private FuncAddCommentCaller funcAddCommentCaller;
    @Autowired
    private FuncQueryCommentByRangeCaller funcQueryCommentByRangeCaller;
    @Autowired
    private IUserService userService;
    @Override
    public ArrayList QueryComments(int message_id, int start_from, int limitation) {
        ArrayList<Map> result=new ArrayList<>();
        ArrayList<Map> comments= funcQueryCommentByRangeCaller.call(message_id,start_from,limitation);
        for(Map i:comments){
            Map comment_for_show=new HashMap();
            comment_for_show.putAll(i);
            comment_for_show.putAll(userService.GetUserPublicInfo(
                    Integer.parseInt(i.get("commentSenderId").toString())));
            result.add(comment_for_show);
        }
        return result;
    }

    @Override
    public void AddComment(int user_id, int be_commented_id, String content) {
        funcAddCommentCaller.call(user_id,be_commented_id,content);
    }
}
