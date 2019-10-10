package com.yzchnb.twitter.dao.TableMapper;

import com.yzchnb.twitter.entity.TableEntity.CommentOnMessage;

public interface CommentOnMessageMapper {
    int deleteByPrimaryKey(Short commentId);

    int insert(CommentOnMessage record);

    int insertSelective(CommentOnMessage record);

    CommentOnMessage selectByPrimaryKey(Short commentId);

    int updateByPrimaryKeySelective(CommentOnMessage record);

    int updateByPrimaryKey(CommentOnMessage record);
}