package com.yzchnb.twitter.controller;


import com.yzchnb.twitter.entity.entityforController.UploadTool;
import com.yzchnb.twitter.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@RestController
@Api(tags = "测试接口")
@RequestMapping(value = "/api/test")
public class TestController {
    @Resource
    private Utils utils;
    @Resource
    private UploadTool uploadTool;

    @PostMapping("/testSendImg")
    @ApiOperation("测试message上传图片功能")
    public void testSendImg(HttpServletRequest request,
                            @RequestParam(value = "imgs")MultipartFile imgs) throws IOException {
        int userId = utils.getUserIdFromCookie(request);
        //暂时没有messageID，用userID代替
        ArrayList<MultipartFile> arrayList = new ArrayList<MultipartFile>(Collections.singletonList(imgs));
        uploadTool.uploadMessage(arrayList,userId);

    }

}
