package com.yzchnb.twitter.utils;

import com.yzchnb.twitter.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class UploadTool {
    @Resource
    Utils utils;


    public void uploadAvatar(MultipartFile multipartFile, Integer avatarId) throws IOException {
        File fileDir = new File(utils.getAvatarsLocation());
        System.out.println(fileDir);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }

        String newName = null;
        String oriName = multipartFile.getOriginalFilename();
        newName = avatarId.toString() ;
        File file = new File(fileDir.getAbsolutePath() + File.separator + newName);
        multipartFile.transferTo(file);
        //System.out.println("上传成功");
    }

    public void uploadMessage(ArrayList<MultipartFile> arr, int messageId) throws IOException {
        File folderPath = new File(utils.getImageLocation() + messageId);
        if(!folderPath.exists()){
            // 递归生成文件夹
            folderPath.mkdirs();
        }
        int i = 0;
        for (MultipartFile file:arr) {
            String oriName = file.getOriginalFilename();
            String newName = String.valueOf(i);
            File newFile = new File(folderPath.getAbsolutePath()+File.separator + newName);
            file.transferTo(newFile);
            i++;
        }
    }


}
