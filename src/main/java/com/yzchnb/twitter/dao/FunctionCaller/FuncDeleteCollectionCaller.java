package com.yzchnb.twitter.dao.FunctionCaller;

import com.yzchnb.twitter.dao.FunctionCaller.BaseCaller.FuncBaseCaller;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeleteCollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FuncDeleteCollectionCaller extends FuncBaseCaller {
	@Autowired
	private FuncDeleteCollectionMapper funcDeleteCollectionMapper;

	public void call(java.lang.Integer userIdInput, java.lang.Integer messageIdInput){
		Map map = new HashMap();
		map.put("userIdInput", userIdInput);
		map.put("messageIdInput", messageIdInput);
		resolveVoid(funcDeleteCollectionMapper, map);
	}
}
