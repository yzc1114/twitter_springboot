package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddPrivateLetterCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncDeletePrivateLetterCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryPrivateLettersCaller;
import com.yzchnb.twitter.service.IPrivateLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class PrivateLetterServiceImpl implements IPrivateLetterService {
    @Autowired
    private FuncQueryPrivateLettersCaller funcQueryPrivateLettersCaller;
    @Autowired
    private FuncAddPrivateLetterCaller funcAddPrivateLetterCaller;
    @Autowired
    private FuncDeletePrivateLetterCaller funcDeletePrivateLetterCaller;
    @Override
    public ArrayList QueryPrivateLetters(int user_id, int start_from, int limitation) {
        return funcQueryPrivateLettersCaller.call(user_id,start_from,limitation);
    }

    @Override
    public void AddPrivateLetter(int sender_user_id, int receiver_user_id, String content) {
        funcAddPrivateLetterCaller.call(sender_user_id,receiver_user_id,content);
    }

    @Override
    public void DeletePrivateLetter(int private_letter_id) {
        funcDeletePrivateLetterCaller.call(private_letter_id);
    }
}
