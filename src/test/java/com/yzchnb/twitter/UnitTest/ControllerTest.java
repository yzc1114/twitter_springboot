package com.yzchnb.twitter.UnitTest;

import com.yzchnb.twitter.configs.ExceptionDefinition.UserException;
import com.yzchnb.twitter.controller.MessageController;
import com.yzchnb.twitter.service.IMessageService;
import com.yzchnb.twitter.utils.UploadTool;
import com.yzchnb.twitter.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import static org.mockito.Mockito.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ControllerTest {
    @MockBean
    IMessageService iMessageService;
    @MockBean
    Utils utils;
    @MockBean
    UploadTool uploadTool;
    @Resource
    MessageController messageController;

    @Test
    public void testSendMessageWithoutImage() throws IOException {
        HttpServletRequest request = mock(MultipartHttpServletRequest.class);
        when(request.getParameter("message_content")).thenReturn("aa");
        when(request.getParameter("message_has_image")).thenReturn("0");
        when(request.getParameter("message_image_count")).thenReturn("0");
        when(utils.getUserIdFromCookie(request)).thenReturn(1);
        when(iMessageService.
                AddMessage("aa", 0, 1, 0))
                .thenReturn(1);

        messageController.Send(request);

        verify(iMessageService).AddMessage("aa", 0, 1, 0);
        verify(uploadTool).uploadMessage(anyList(),eq(1));
    }

    @Test
    public void testSendMessageWithImage() throws IOException {
        MultipartHttpServletRequest request = mock(MultipartHttpServletRequest.class);
        when(request.getParameter("message_content")).thenReturn("aa");
        when(request.getParameter("message_has_image")).thenReturn("1");
        when(request.getParameter("message_image_count")).thenReturn("10");
        when(utils.getUserIdFromCookie(request)).thenReturn(1);

        for(int i=0;i<10;++i){
            when(request.getFile("file"+i)).thenReturn(mock(MultipartFile.class));
        }
        when(iMessageService.
                AddMessage("aa", 1, 1, 10))
                .thenReturn(1);

        messageController.Send(request);

        verify(iMessageService).AddMessage("aa", 1, 1, 10);
        verify(uploadTool).uploadMessage(anyList(),eq(1));
    }

    @Test(expected = UserException.class)
    public void testSendMessageWithoutSignIn() throws IOException {
        MultipartHttpServletRequest request = mock(MultipartHttpServletRequest.class);
        when(request.getParameter("message_content")).thenReturn("aa");
        when(request.getParameter("message_has_image")).thenReturn("1");
        when(request.getParameter("message_image_count")).thenReturn("10");
        when(utils.getUserIdFromCookie(request)).thenReturn(0);

        for(int i=0;i<10;++i){
            when(request.getFile("file"+i)).thenReturn(mock(MultipartFile.class));
        }
        when(iMessageService.
                AddMessage("aa", 1, 1, 10))
                .thenReturn(1);

        messageController.Send(request);

    }
}
