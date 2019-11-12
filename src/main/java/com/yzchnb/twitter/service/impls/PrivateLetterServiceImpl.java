package com.yzchnb.twitter.service.impls;

import com.yzchnb.twitter.dao.FunctionCaller.FuncAddPrivateLetterCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncDeletePrivateLetterCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQueryPrivateLettersCaller;
import com.yzchnb.twitter.dao.FunctionCaller.FuncQuerySpecifiedCaller;
import com.yzchnb.twitter.service.IPrivateLetterService;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class PrivateLetterServiceImpl implements IPrivateLetterService {
    @Autowired
    private FuncQueryPrivateLettersCaller funcQueryPrivateLettersCaller;
    @Autowired
    private FuncAddPrivateLetterCaller funcAddPrivateLetterCaller;
    @Autowired
    private FuncDeletePrivateLetterCaller funcDeletePrivateLetterCaller;
    @Autowired
    private FuncQuerySpecifiedCaller funcQuerySpecifiedCaller;
    @Autowired
    private IUserService userService;
    @Override
    public ArrayList QueryPrivateLetters(int user_id, int start_from, int limitation) {
        ArrayList<Map> letters=funcQueryPrivateLettersCaller.call(user_id,start_from,limitation);
        for(Map letter:letters){
            letter.put("senderInfo",userService.GetUserPublicInfo(
                    Integer.parseInt(letter.get("privateLetterSenderId").toString())));
        }
        return letters;
    }

    @Override
    public void AddPrivateLetter(int sender_user_id, int receiver_user_id, String content) {
        funcAddPrivateLetterCaller.call(sender_user_id,receiver_user_id,content);
    }

    @Override
    public ArrayList QuerySpecified(int sender_id,int receiver_id, int start_from, int limitation) {
        ArrayList<Map> letters = funcQuerySpecifiedCaller.call(sender_id,receiver_id,start_from,limitation);
        for(Map letter:letters){
            letter.put("senderInfo",userService.GetUserPublicInfo(
                    Integer.parseInt(letter.get("privateLetterSenderId").toString())));
        }
        return letters;
    }

    @Override
    public void DeletePrivateLetter(int private_letter_id) {
        funcDeletePrivateLetterCaller.call(private_letter_id);
    }
}
