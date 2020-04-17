package com.yisu.security.controller;

import cn.hutool.json.JSONUtil;
import com.yisu.security.model.ImageCode;
import com.yisu.security.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class ValidateCodeController {

    private final String SESSION_KEY="SESSION_KEY_IMAGE_CODE";

    @Autowired
    private ValidateCodeService validateCodeService;

    /**
     * 操作session的工具类
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode= (ImageCode) validateCodeService.generate(new ServletWebRequest(request, response));
        redisTemplate.opsForValue().set(SESSION_KEY, JSONUtil.toJsonStr(imageCode));
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }
}
