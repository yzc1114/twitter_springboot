package com.yzchnb.twitter;


import com.yzchnb.twitter.dao.FunctionCaller.*;
import com.yzchnb.twitter.dao.FunctionMapper.FuncDeleteLikeMapper;
import com.yzchnb.twitter.dao.FunctionMapper.FuncRecommendUserMapper;
import com.yzchnb.twitter.dao.FunctionMapper.FuncUserSignUpMapper;
import com.yzchnb.twitter.dao.TableMapper.UserPublicInfoMapper;
import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionCallerTests {

    @Resource
    AddAvatarCaller addAvatarCaller;
    @Resource
    FuncAddAtUserCaller funcAddAtUserCaller;
    @Resource
    FuncAddCollectionCaller funcAddCollectionCaller;
    @Resource
    FuncAddCommentCaller funcAddCommentCaller;
    @Resource
    FuncAddLikeCaller funcAddLikeCaller;
    @Resource
    FuncAddPrivateLetterCaller funcAddPrivateLetterCaller;
    @Resource
    FuncAddRelationCaller funcAddRelationCaller;
    @Resource
    FuncAddTopicCaller funcAddTopicCaller;
    @Resource
    FuncCheckUserEmailExistCaller funcCheckUserEmailExistCaller;
    @Resource
    FuncCheckUserIdExistCaller funcCheckUserIdExistCaller;
    @Resource
    FuncDeleteCollectionCaller funcDeleteCollectionCaller;
    @Resource
    FuncDeleteLikeCaller funcDeleteLikeCaller;
    @Resource
    FuncDeleteMessageCaller funcDeleteMessageCaller;
    @Resource
    FuncDeletePrivateLetterCaller funcDeletePrivateLetterCaller;
    @Resource
    FuncGetCollectionNumCaller funcGetCollectionNumCaller;
    @Resource
    FuncGetMessageNumCaller funcGetMessageNumCaller;
    @Resource
    FuncGetTopicIdByNameCaller funcGetTopicIdByNameCaller;
    @Resource
    FuncGetUserAvatarCaller funcGetUserAvatarCaller;
    @Resource
    FuncGetUserIdByNameCaller funcGetUserIdByNameCaller;
    @Resource
    FuncGetUserPrivateInfoCaller funcGetUserPrivateInfoCaller;
    @Resource
    FuncGetUserPublicInfoCaller funcGetUserPublicInfoCaller;
    @Resource
    FuncIfFollowingCaller funcIfFollowingCaller;
    @Resource
    FuncQueryCollectionsOfMineCaller funcQueryCollectionsOfMineCaller;
    @Resource
    FuncQueryCommentByRangeCaller funcQueryCommentByRangeCaller;
    @Resource
    FuncQueryFollowersListCaller funcQueryFollowersListCaller;
    @Resource
    FuncQueryFollowingListCaller funcQueryFollowingListCaller;
    @Resource
    FuncQueryIfUserCollectsCaller funcQueryIfUserCollectsCaller;
    @Resource
    FuncQueryMessageAtUserCaller funcQueryMessageAtUserCaller;
    @Resource
    FuncQueryMessageByTopicCaller funcQueryMessageByTopicCaller;
    @Resource
    FuncQueryMessageIdsLikesCaller funcQueryMessageIdsLikesCaller;
    @Resource
    FuncQueryPrivateLettersCaller funcQueryPrivateLettersCaller;
    @Resource
    FuncQueryTopicsByHeatCaller funcQueryTopicsByHeatCaller;
    @Resource
    FuncQueryUnreadAtCaller funcQueryUnreadAtCaller;
    @Resource
    FuncQueryUserLikesMessageCaller funcQueryUserLikesMessageCaller;
    @Resource
    FuncRecommendUserCaller funcRecommendUserCaller;
    @Resource
    FuncRemoveRelationCaller funcRemoveRelationCaller;
    @Resource
    FuncSearchMessageCaller funcSearchMessageCaller;
    @Resource
    FuncSearchTopicsCaller funcSearchTopicsCaller;
    @Resource
    FuncSearchUserCaller funcSearchUserCaller;
    @Resource
    FuncSendMessageCaller funcSendMessageCaller;
    @Resource
    FuncSetMainAvatarCaller funcSetMainAvatarCaller;
    @Resource
    FuncSetUserInfoCaller funcSetUserInfoCaller;
    @Resource
    FuncShowFollowMessageCaller funcShowFollowMessageCaller;
    @Resource
    FuncShowMessageByIdCaller funcShowMessageByIdCaller;
    @Resource
    FuncShowMessageByRangeCaller funcShowMessageByRangeCaller;
    @Resource
    FuncShowMessageByTimeCaller funcShowMessageByTimeCaller;
    @Resource
    FuncTranspondMessageCaller funcTranspondMessageCaller;
    @Resource
    FuncUserSignInByEmailCaller funcUserSignInByEmailCaller;
    @Resource
    FuncUserSignUpCaller funcUserSignUpCaller;

    @Test
    public void testAddAvatarCaller(){
        addAvatarCaller.call(1);
    }

    @Test
    public void testFuncAddAtUserCaller(){
        funcAddAtUserCaller.call("wxt",10,64);
    }

    @Test
    public void testFuncAddCollectionCaller(){
        funcAddCollectionCaller.call(64,1);
    }

    @Test
    public void testFuncAddCommentCaller(){
        funcAddCommentCaller.call(64,1,"Good job!");
    }

    @Test
    public void testFuncAddLikeCaller(){
        funcAddLikeCaller.call(64,1);
    }

    @Test
    public void testFuncAddPrivateLetterCaller(){
        funcAddPrivateLetterCaller.call(64,1,"Fuck you!");
    }

    @Test
    public void testAddRelationCaller(){
        funcAddRelationCaller.call(64,1);
    }

    @Test
    public void testAddTopicCaller(){
        funcAddTopicCaller.call("number",1);
    }

    @Test
    public void testFuncCheckUserEmailExistCaller(){
        funcCheckUserEmailExistCaller.call("564318045@qq.com");
    }

    @Test
    public void testFuncCheckUserIdExistCaller(){
        funcCheckUserIdExistCaller.call("wxt");
    }

    @Test
    public void testFuncDeleteCollectionCaller(){
        funcDeleteCollectionCaller.call(64,1);
    }

    @Test
    public void testFuncDeleteLikeCaller(){
        funcDeleteLikeCaller.call(64,1);
    }

    @Test
    public void testFuncDeleteMessageCaller(){
        funcDeleteMessageCaller.call(1);
    }

    @Test
    public void testFuncDeletePrivateLetterCaller(){
        funcDeletePrivateLetterCaller.call(1);
    }

    @Test
    public void testFuncGetCollectionNumCaller(){
        funcGetCollectionNumCaller.call(64);
    }
    @Test
    public void testFuncGetMessageNumCaller(){
        funcGetMessageNumCaller.call(64);
    }

    @Test
    public void testFuncGetTopicIdByNameCaller(){
        funcGetTopicIdByNameCaller.call("number");
    }

    @Test
    public void testFuncGetUserAvatarCaller(){
        funcGetUserAvatarCaller.call(64);
    }

    @Test
    public void testFuncGetUserIdByNameCaller(){
        funcGetUserIdByNameCaller.call("wxt");
    }

    @Test
    public void testFuncGetUserPrivateInfoCaller(){
        funcGetUserPrivateInfoCaller.call(64);
    }

    @Test
    public void testFuncGetUserPublicInfoCaller(){
        funcGetUserPublicInfoCaller.call(64);
    }

    @Test
    public void testFuncIfFollowingCaller(){
        funcIfFollowingCaller.call(64,1);
    }

    @Test
    public void testFuncQueryCollectionOfMineCaller(){
        funcQueryCollectionsOfMineCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryCommentByRangeCaller(){
        funcQueryCommentByRangeCaller.call(1,1,5);
    }

    @Test
    public void testFuncQueryFollowerListCaller(){
        funcQueryFollowersListCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryFollowingListCaller(){
        funcQueryFollowingListCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryIfUserCollectsCaller(){
        funcQueryIfUserCollectsCaller.call(64,1);
    }

    @Test
    public void testFuncQueryMessageAtUserCaller(){
        funcQueryMessageAtUserCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryMessageByTopicCaller(){
        funcQueryMessageByTopicCaller.call(1,1,5);
    }

    @Test
    public void testFuncQueryMessageIdsLikesCaller(){
        funcQueryMessageIdsLikesCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryPrivateLettersCaller(){
        funcQueryPrivateLettersCaller.call(64,1,5);
    }

    @Test
    public void testFuncQueryTopicsByHeatCaller(){
        funcQueryTopicsByHeatCaller.call(1,5);
    }

    @Test
    public void testFuncQueryUnreadAtCaller(){
        funcQueryUnreadAtCaller.call(64);
    }

    @Test
    public void testFuncQueryUserLikesMessageCaller(){
        funcQueryUserLikesMessageCaller.call(64,1);
    }

    @Test
    public void testFuncRecommendUserCaller(){
        funcRecommendUserCaller.call();
    }

    @Test
    public void testFuncRemoveRelationCaller(){
        funcRemoveRelationCaller.call(64,1);
    }

    @Test
    public void testFuncSearchMessageCaller(){
        funcSearchMessageCaller.call("he",1,5);
    }

    @Test
    public void testFuncSearchTopicsCaller(){
        funcSearchTopicsCaller.call("num",1,5);
    }

    @Test
    public void testFuncUserCaller(){
        funcSearchUserCaller.call("wx",1,5);
    }

    @Test
    public void testFuncSendMessageCaller(){
        funcSendMessageCaller.call("HelloWorld",0,64,0);
    }

    @Test
    public void testFuncSetMainAvatarCaller(){
        funcSetMainAvatarCaller.call(64,1);
    }

    @Test
    public void testFuncSetUserInfoCaller(){
        funcSetUserInfoCaller.call("tzc","nothing","123456",
                "lalala","男",85,1);
    }

    @Test
    public void testFuncShowFollowMessageCaller(){
        funcShowFollowMessageCaller.call(1,5,64);
    }

    @Test
    public void testFuncShowMessageByIdCaller(){
        funcShowMessageByIdCaller.call(1);
    }

    @Test
    public void testFuncShowMessageByRangeCaller(){
        funcShowMessageByRangeCaller.call(64,1,5);
    }

    @Test
    public void testFuncShowMessageByTimeCaller(){
        funcShowMessageByTimeCaller.call(1,5);
    }

    @Test
    public void testFuncTranspondMessageCaller(){
        funcTranspondMessageCaller.call("lala",0,64,
                1);
    }

    @Test
    public void testFuncUserSignInByEmailCaller(){
        funcUserSignInByEmailCaller.call("564318045@qq.com","19981229");
    }

    @Test
    public void testFuncUserSignUpCaller(){
            funcUserSignUpCaller.call("1234567@qq.com", "suibian", "123123");
    }
}
