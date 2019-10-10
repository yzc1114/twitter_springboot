package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddPrivateLetterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddPrivateLetterCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddPrivateLetterMapper funcAddPrivateLetterMapper;

	public void call(java.lang.Integer senderUserId, java.lang.Integer receiverUserId, java.lang.String content){
		Map map = new HashMap();
		map.put("sender_user_id", senderUserId);
		map.put("receiver_user_id", receiverUserId);
		map.put("content", content);
		resolveVoid(funcAddPrivateLetterMapper, map);
	}
}
