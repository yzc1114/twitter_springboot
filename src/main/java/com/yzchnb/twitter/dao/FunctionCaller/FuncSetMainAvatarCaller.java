package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncSetMainAvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncSetMainAvatarCaller extends FuncBaseCaller {
	@Autowired
	private FuncSetMainAvatarMapper funcSetMainAvatarMapper;

	public void call(java.lang.Integer userid, java.lang.Integer avatarid){
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("avatarid", avatarid);
		resolveVoid(funcSetMainAvatarMapper, map);
	}
}
