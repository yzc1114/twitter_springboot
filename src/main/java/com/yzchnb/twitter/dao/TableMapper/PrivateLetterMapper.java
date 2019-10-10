package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.PrivateLetter;

public interface PrivateLetterMapper {
    int deleteByPrimaryKey(Short privateLetterId);

    int insert(PrivateLetter record);

    int insertSelective(PrivateLetter record);

    PrivateLetter selectByPrimaryKey(Short privateLetterId);

    int updateByPrimaryKeySelective(PrivateLetter record);

    int updateByPrimaryKey(PrivateLetter record);
}