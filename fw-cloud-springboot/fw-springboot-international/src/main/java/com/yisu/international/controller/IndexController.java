package com.yisu.international.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 * @Author xuyisu
 * @Date 2019/12/6
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
