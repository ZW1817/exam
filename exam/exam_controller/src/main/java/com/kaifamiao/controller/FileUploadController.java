package com.kaifamiao.controller;

import com.kaifamiao.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping
public class FileUploadController {

    @RequestMapping("/upload")
    public ResponseUtil upload(Integer id, MultipartFile multipartFile, MultipartHttpServletRequest request){
        try {
            multipartFile.transferTo(new File("F:/kaifamiao/code/temp1/d.jpg"));
            return new ResponseUtil(1,"上传成功",null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseUtil(0,"上传失败",null);
    }
}
