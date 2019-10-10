package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.UserPrivateInfo;

public interface UserPrivateInfoMapper {
    int deleteByPrimaryKey(Short userId);

    int insert(UserPrivateInfo record);

    int insertSelective(UserPrivateInfo record);

    UserPrivateInfo selectByPrimaryKey(Short userId);

    int updateByPrimaryKeySelective(UserPrivateInfo record);

    int updateByPrimaryKey(UserPrivateInfo record);
}