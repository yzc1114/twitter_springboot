package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.AtUser;
import com.yzchnb.twitter.entity.TableEntity.AtUserKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AtUserMapper {
    int deleteByPrimaryKey(AtUserKey key);

    int insert(AtUser record);

    int insertSelective(AtUser record);

    AtUser selectByPrimaryKey(AtUserKey key);

    int updateByPrimaryKeySelective(AtUser record);

    int updateByPrimaryKey(AtUser record);
}