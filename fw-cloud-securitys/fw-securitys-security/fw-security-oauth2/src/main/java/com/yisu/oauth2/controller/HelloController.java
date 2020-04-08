package com.yisu.oauth2.controller;

import com.yisu.common.result.FwResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@RestController
@Slf4j
@RequestMapping("users")
public class HelloController {


    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/user")
    public FwResult getUser() {
        List<Map<String, String>> maps = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("username", "李四");
        map.put("sex", "男");
        maps.add(map);
        return FwResult.ok(maps);
    }


}
