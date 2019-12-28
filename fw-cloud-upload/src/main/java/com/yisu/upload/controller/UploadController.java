package com.yisu.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author xuyisu
 * @description 上传
 * @date 2019/12/28
 */
@RestController
@Slf4j
public class UploadController {
    @PostMapping(value = "/uploadFile")
    public String uploadFile(MultipartFile file) throws Exception {
        log.info("upload file name : {}", file.getName());
        //上传文件
        file.transferTo(new File("D:/fw/file/" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }


}
