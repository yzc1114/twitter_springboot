package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.TranspondKey;

public interface TranspondMapper {
    int deleteByPrimaryKey(TranspondKey key);

    int insert(TranspondKey record);

    int insertSelective(TranspondKey record);
}