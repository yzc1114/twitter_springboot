package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncAddAtUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncAddAtUserCaller extends FuncBaseCaller {
	@Autowired
	private FuncAddAtUserMapper funcAddAtUserMapper;

	public void call(java.lang.String atNickname, java.lang.Integer atmessageId, java.lang.Integer sourceUserId){
		Map map = new HashMap();
		map.put("atNickname", atNickname);
		map.put("atmessageId", atmessageId);
		map.put("sourceUserId", sourceUserId);
		resolveVoid(funcAddAtUserMapper, map);
	}
}
