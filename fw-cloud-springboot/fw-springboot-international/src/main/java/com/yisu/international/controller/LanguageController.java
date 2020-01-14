package com.yisu.international.controller;

import com.yisu.common.result.FwResult;
import com.yisu.international.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 设置语言环境
 * @Author xuyisu
 * @Date 2019/12/6
 */
@RestController
public class LanguageController {


    @Autowired
    private MessageUtil messageUtil;


    /**
     * 设置语言
     * @param request
     * @param response
     * @param lang
     * @return
     */
    @GetMapping("/setLang")
    public FwResult getInfoByLang(HttpServletRequest request, HttpServletResponse response,
                                  String lang){
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if("zh".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("zh", "CN"));
        }else if("en".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("en", "US"));
        }
        return FwResult.okMsg("设置"+lang+"成功");
    }


    /**
     * 根据key  获取内容
     * @param key
     * @return
     */
    @GetMapping("/getValue")
    public FwResult getValue(String key) {
        String welcome = messageUtil.getMessage(key);
        return FwResult.ok(welcome);
    }
}
