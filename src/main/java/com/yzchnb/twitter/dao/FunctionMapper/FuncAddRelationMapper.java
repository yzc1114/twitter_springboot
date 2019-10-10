package com.yzchnb.twitter.dao.FunctionMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface FuncAddRelationMapper {
	void call(Map map);
}
