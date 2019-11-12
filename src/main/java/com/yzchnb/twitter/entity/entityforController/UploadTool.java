package com.yzchnb.twitter.entity.entityforController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class UploadTool {

    @Value("${upload.avatarPath}")
    private String avatarPath;
    @Value("${upload.messagePath}")
    private String messagePath;

    public String uploadAvatar(MultipartFile multipartFile, Integer avatarId) throws IOException {
        File fileDir = new File(avatarPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }

        String newName = null;
        String oriName = multipartFile.getOriginalFilename();
        newName = avatarId.toString() + oriName.substring(oriName.lastIndexOf('.'));
        File file = new File(fileDir.getAbsolutePath() + File.separator + newName);
        multipartFile.transferTo(file);
        //System.out.println("上传成功");
        return avatarPath + newName;
    }

    public void uploadMessage(ArrayList<MultipartFile> arr, int messageId) throws IOException {
        File folderPath = new File(messagePath + messageId);
        if(!folderPath.exists()){
            // 递归生成文件夹
            folderPath.mkdirs();
        }
        int i = 0;
        for (MultipartFile file:arr) {
            String oriName = file.getOriginalFilename();
            String newName = i + oriName.substring(oriName.lastIndexOf('.'));
            File newFile = new File(folderPath.getAbsolutePath()+File.separator + newName);
            file.transferTo(newFile);
            i++;
        }
    }


}
