package com.yisu.feign.controller;

import com.yisu.feign.service.EurekaFeignService;
import com.yisu.feign.service.FileUploadFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author xuyisu
 * @description controller
 * @date 2019/12/11
 */
@RestController
@Slf4j
public class EurekaFeignController {

    @Resource
    private EurekaFeignService eurekaFeignService;

    @Resource
    private FileUploadFeignService fileUploadFeignService;

    @GetMapping("/feignInfo")
    public String feignInfo() {
        String message = eurekaFeignService.hello();
        log.info(message);
        return message;
    }

    @PostMapping(value = "/upload")
    public String upload(MultipartFile file){
        return fileUploadFeignService.uploadFile(file);
    }


}
