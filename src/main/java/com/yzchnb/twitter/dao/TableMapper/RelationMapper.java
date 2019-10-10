package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.Relation;
import com.yzchnb.twitter.entity.TableEntity.RelationKey;

public interface RelationMapper {
    int deleteByPrimaryKey(RelationKey key);

    int insert(Relation record);

    int insertSelective(Relation record);

    Relation selectByPrimaryKey(RelationKey key);

    int updateByPrimaryKeySelective(Relation record);

    int updateByPrimaryKey(Relation record);
}