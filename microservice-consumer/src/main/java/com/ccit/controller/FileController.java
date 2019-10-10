package com.ccit.controller;


import com.ccit.util.FastDFSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
;

import java.io.IOException;
import java.util.Map;

@Controller
public class FileController {

    @Autowired
    private FastDFSClientUtil fastDFSClientUtil;


    @RequestMapping("upload")
    public  String uploadFile(MultipartFile file, Map map){
        System.out.println(file==null?"空的":"不空的");
        try {
            String url=fastDFSClientUtil.uploadFile(file);
            map.put("message","成功上传了文件，地址为:"+url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "test";
    }

}
