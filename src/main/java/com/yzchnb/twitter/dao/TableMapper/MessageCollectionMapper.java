package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.MessageCollectionKey;

public interface MessageCollectionMapper {
    int deleteByPrimaryKey(MessageCollectionKey key);

    int insert(MessageCollectionKey record);

    int insertSelective(MessageCollectionKey record);
}