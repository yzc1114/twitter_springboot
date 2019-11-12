package com.yzchnb.twitter;

import com.yzchnb.twitter.entity.TableEntity.UserPublicInfo;
import com.yzchnb.twitter.entity.entityforController.UserEntity.UserInfoEdit;
import com.yzchnb.twitter.service.ICollectionService;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.service.IRelationService;
import com.yzchnb.twitter.service.IUserService;
import com.yzchnb.twitter.service.impls.*;
import com.yzchnb.twitter.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {
    @Resource
    AtUserServiceImpl atUserService;
    @Resource
    AvatarServiceImpl avatarService;
    @Resource
    CollectionServiceImpl collectionService;
    @Resource
    CommentServiceImpl commentService;
    @Resource
    LikeServiceImpl likeService;
    @Resource
    MessageServiceImpl messageService;
    @Resource
    PrivateLetterServiceImpl privateLetterService;
    @Resource
    RelationServiceImpl relationService;
    @Resource
    SearchServiceImpl searchService;
    @Resource
    TopicServiceImpl topicService;
    @Resource
    UserServiceImpl userService;

    /*@Test
    public void testAtUserServiceImpl(){
        System.out.println(atUserService.Query(64,1,5));
        System.out.println(atUserService.QueryUnreadAt(64));
        atUserService.AddUserAt("wxt",1,64);
    }

    @Test
    public void testAvatarServiceImpl(){
        avatarService.SetMainAvatar(64,1);
        System.out.println(avatarService.AddAvatar(64));
        System.out.println(avatarService.GetMainAvatar(64));
    }

    @Test
    public void testCollectionServiceImpl(){
        System.out.println(collectionService.GetCollectionNum(64));
        System.out.println(collectionService.IfCollecting(64,1));
        collectionService.Add(64,2);
        collectionService.Delete(64,2);
    }

    @Test
    public void testCommentServiceImpl(){
        commentService.AddComment(64,1,"Well Done!");
        System.out.println(commentService.QueryComments(1,1,5));
    }

    @Test
    public void testLikeServiceImpl(){
        likeService.AddLike(64,10);
        likeService.IfLike(64,10);
        System.out.println(likeService.QueryLikes(64,1,5));
        likeService.CancelLike(64,10);
    }

    @Test
    public void testMessageServiceImpl(){
        messageService.AddMessage("6666666",0,64,0);
        System.out.println(messageService.QueryMessage(6));
        messageService.Delete(1);
        System.out.println(messageService.TransponderMessage("666",0,
                64,1));
        System.out.println(messageService.QueryFollowMessage(64,1,5));
        System.out.println(messageService.QueryNewest(1,5));
        System.out.println(messageService.QueryUserMessage(64,1,5));
    }*/

    @Test
    public void testPrivateLetterServiceImpl(){
        //privateLetterService.AddPrivateLetter(64,1,"fuck");
        //System.out.println(privateLetterService.QueryPrivateLetters(1,1,5));
        //privateLetterService.DeletePrivateLetter(1);
        System.out.println(privateLetterService.QueryLatestContact(7,0,100));
    }

    /*@Test
    public void testRelationServiceImpl(){
        relationService.FollowUser(1,64);
        System.out.println(relationService.IfFollowing(1,64));
        System.out.println(relationService.QueryFollowersFor(64,1,5));
        System.out.println(relationService.QueryFollowingFor(1,1,5));
        relationService.CancelFollowingTo(1,64);
    }

    @Test
    public void testSearchServiceImpl(){
        System.out.println(searchService.GetTopicResults("he",1,5));
        System.out.println(searchService.GetTwitterResults("he",1,5));
        System.out.println(searchService.GetUserResults("he",1,5));
    }

    @Test
    public void testTopicServiceImpl(){
        topicService.AddTopicWithMessage("number",1);
        System.out.println(topicService.GetTopicIdByName("number"));
        System.out.println(topicService.QueryTopicsBaseOnHeat(1,5));
        System.out.println(topicService.QueryMessageByTopic(1,1,5));
    }

    @Test
    public void testUserServiceImpl(){
        userService.SignUp("wxt@163.com","wxtnb","19981229");
        userService.CheckUserEmail("wxt@163.com");
        userService.SignIn("wxt@163.com","19981229");
        System.out.println(userService.GetRecommend());
        System.out.println(userService.GetUserPublicInfo(64));
        System.out.println(userService.GetAllInfo(64));
        System.out.println(userService.GetUserMessageNum(64));
        userService.EditInfo(new UserInfoEdit(),64);
    }*/
}
