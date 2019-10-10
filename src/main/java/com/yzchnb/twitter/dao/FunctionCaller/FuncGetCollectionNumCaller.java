package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncGetCollectionNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncGetCollectionNumCaller extends FuncBaseCaller {
	@Autowired
	private FuncGetCollectionNumMapper funcGetCollectionNumMapper;

	public java.lang.Integer call(java.lang.Integer myUserId){
		Map map = new HashMap();
		map.put("my_user_id", myUserId);
		return resolveInteger(funcGetCollectionNumMapper, map);
	}
}
