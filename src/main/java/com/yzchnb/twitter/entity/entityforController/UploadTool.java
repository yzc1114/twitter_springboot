package com.yzchnb.twitter.entity.entityforController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class UploadTool {

    @Value("${uploadPath}")
    private String path;

    public String upload(MultipartFile multipartFile, Integer avatarId) throws IOException {
        String newName = null;
        String oriName = multipartFile.getOriginalFilename();
        newName = avatarId.toString() + oriName.substring(oriName.lastIndexOf('.'));
        File file = new File(path + newName);
        multipartFile.transferTo(file);
        System.out.println("上传成功");
        return path + newName;
    }
}
