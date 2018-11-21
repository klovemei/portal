package com.jyanedu.app.service;

import com.jyanedu.app.common.StaticProp;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by liu_kai on 2018/2/11.
 */
@Service
public class ImgService {
    public String uploadFile(MultipartFile file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String pathStr = sdf.format(new Date())+"/";
        String imgPath = StaticProp.imgPath+pathStr;
        String fileName = file.getOriginalFilename();
        String imgFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
        File path = new File(imgPath);
        if(!path.exists())path.mkdirs();
        File localFile = new File(imgPath+imgFileName);
        FileOutputStream outputStream = new FileOutputStream(localFile);
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
        return pathStr+imgFileName;
    }
    public boolean delImgFile(String imgUrl){
        File file = new File(StaticProp.imgPath+imgUrl);
        if(!file.isFile())return false;
        file.deleteOnExit();
        return true;
    }
}
