package com.jyanedu.app.controller;

import com.jyanedu.app.common.StaticProp;
import com.jyanedu.app.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
public class ImgController {
    @Autowired
    ImgService imgService;
    @RequestMapping(value = "/admin/imgUpload")
    public String uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        return imgService.uploadFile(file);
    }
}
