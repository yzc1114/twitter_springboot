package com.yzchnb.twitter.UnitTest;

import com.yzchnb.twitter.dao.FunctionCaller.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionCallTest {
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
    @Resource
    FuncQueryLatestContactCaller funcQueryLatestContactCaller;
    @Resource
    FuncQuerySpecifiedCaller funcQuerySpecifiedCaller;
    @Resource
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSignUp() {
        String email = "114514810@qq.com";
        String nickname = "114514";
        String password = "123456";
        int re = funcCheckUserEmailExistCaller.call(email);
        Assert.assertEquals(0, re);
        funcUserSignUpCaller.call(email, nickname, password);
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();
        re = funcCheckUserEmailExistCaller.call(email);
        Assert.assertEquals(1, re);
    }

    @Test
    public void testSetUserInfo() {
        int id = 51;
        String nickname = "new_nickname";
        String self_introduction = "new introduction";
        String password = "111111";
        String real_name = "xiaoming";
        String gender = "Male";
        funcSetUserInfoCaller.call(nickname, null, null, null, null, id, 1);
        Map result = (Map) funcGetUserPublicInfoCaller.call(id).get(0);
        Assert.assertEquals(nickname, result.get("userNickname"));
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();

        funcSetUserInfoCaller.call(null, self_introduction, null, null, null, id, 1 << 1);
        result = (Map) funcGetUserPublicInfoCaller.call(id).get(0);
        Assert.assertEquals(self_introduction, result.get("userSelfIntroduction"));
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();

        funcSetUserInfoCaller.call(null, null, password, null, null, id, 1 << 2);
        result = (Map) funcGetUserPrivateInfoCaller.call(id).get(0);
        Assert.assertEquals(password, result.get("userPassword"));
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();

        funcSetUserInfoCaller.call(null, null, null, real_name, null, id, 1 << 3);
        result = (Map) funcGetUserPrivateInfoCaller.call(id).get(0);
        Assert.assertEquals(real_name, result.get("userRealName"));
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();

        funcSetUserInfoCaller.call(null, null, null, null, gender, id, 1 << 4);
        result = (Map) funcGetUserPrivateInfoCaller.call(id).get(0);
        Assert.assertEquals(gender, result.get("userGender"));
        SqlSessionUtils.getSqlSession(sqlSessionFactory).clearCache();
    }

    @Test
    public void testGetUserAvatar() {
        Assert.assertEquals(61, (int) funcGetUserAvatarCaller.call(2));
    }

    @Test
    public void testSetUserAvatar() {
        funcSetMainAvatarCaller.call(51, 0);
        Assert.assertEquals(0, (int) funcGetUserAvatarCaller.call(51));
    }

    @Test
    public void testAddTopic() {
        funcAddTopicCaller.call("topic", 1);
        Assert.assertNotNull(funcGetTopicIdByNameCaller.call("topic"));
    }

    @Test
    public void testAddMessage() {
        funcSendMessageCaller.call("new_message", 0, 1, 0);
        Assert.assertNotEquals(0, funcSearchMessageCaller.call("new_message", 0, 10).size());
        funcSendMessageCaller.call("new_image", 1, 1, 1);
        Assert.assertNotEquals(0, funcSearchMessageCaller.call("new_image", 0, 10).size());
    }

    @Test
    public void testTranspondMessage() {
        funcTranspondMessageCaller.call("transpond1", 0, 1, 1);
        Assert.assertNotEquals(0, funcSearchMessageCaller.call("transpond1", 0, 10).size());
        funcTranspondMessageCaller.call("transpond2", 1, 1, 3);
        Assert.assertNotEquals(0, funcSearchMessageCaller.call("transpond2", 0, 10).size());
    }

    @Test
    public void testAddCollection(){
        funcAddCollectionCaller.call(1,1);
        Assert.assertEquals(1,(int)funcQueryIfUserCollectsCaller.call(1,1));
    }

    @Test
    public void testDeleteCollection(){
        funcDeleteCollectionCaller.call(1,1);
        Assert.assertEquals(0,(int)funcQueryIfUserCollectsCaller.call(1,1));
    }

    @Test
    public void testAddLike(){
        funcAddLikeCaller.call(1,1);
        Assert.assertEquals(1,(int)funcQueryUserLikesMessageCaller.call(1,1));
    }
    @Test
    public void testDeleteLike(){
        funcDeleteLikeCaller.call(1,1);
        Assert.assertEquals(0,(int)funcQueryUserLikesMessageCaller.call(1,1));
    }
    @Test
    public void testAddComment(){
        funcAddCommentCaller.call(1,1,"content");
        Assert.assertNotEquals(0,funcQueryCommentByRangeCaller.call(1,0,10).size());
    }
    @Test
    public void testAtUser(){
        funcAddAtUserCaller.call("new_nickname",1,1);
        Assert.assertNotEquals(0,(int)funcQueryMessageAtUserCaller.call(51,0,10).size());
    }
    @Test
    public void testCollectionQuery(){
        Assert.assertEquals(0,funcQueryCollectionsOfMineCaller.call(1,0,10).size());
    }

    @Test
    public void testFollowersQuery(){
        Assert.assertEquals(0,funcQueryFollowersListCaller.call(1,0,10).size());
    }

    @Test
    public void testFollowingQuery(){
        Assert.assertEquals(0,funcQueryFollowingListCaller.call(1,0,10).size());
    }

    @Test
    public void testQueryLatestPrivateLetter(){
        Assert.assertEquals(0,funcQueryLatestContactCaller.call(1,0,10).size());
    }

    @Test
    public void testQueryMessagesOfTopic(){
        int id=funcGetTopicIdByNameCaller.call("topic");
        Assert.assertEquals(1,funcQueryMessageByTopicCaller.call(id,0,10).size());
    }

    @Test
    public void testQueryUserLikes(){
        Assert.assertEquals(0,funcQueryMessageIdsLikesCaller.call(1,0,10).size());
    }

    @Test
    public void testQueryPrivateLetters(){
        Assert.assertEquals(0,funcQueryPrivateLettersCaller.call(1,0,10).size());
    }

    @Test
    public void testQuerySpecified(){
        Assert.assertEquals(0,funcQuerySpecifiedCaller.call(1,51,0,10).size());
    }

    @Test
    public void testShowFollow(){
        Assert.assertEquals(0,funcShowFollowMessageCaller.call(1,10,51).size());
    }
}
