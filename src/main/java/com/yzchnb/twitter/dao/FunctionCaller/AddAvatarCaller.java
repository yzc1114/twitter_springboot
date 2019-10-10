package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.AddAvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AddAvatarCaller extends FuncBaseCaller {
	@Autowired
	private AddAvatarMapper addAvatarMapper;

	public java.lang.Integer call(java.lang.Integer userId){
		Map map = new HashMap();
		map.put("user_id", userId);
		return resolveInteger(addAvatarMapper, map);
	}
}
