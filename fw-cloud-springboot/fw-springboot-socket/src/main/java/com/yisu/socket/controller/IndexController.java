package com.yisu.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuyisu
 * @description //TODO
 * @date 2021/11/10
 */
@Controller
public class IndexController {

    @RequestMapping("page")
    public String page(){
        return "websocket";
    }
}
