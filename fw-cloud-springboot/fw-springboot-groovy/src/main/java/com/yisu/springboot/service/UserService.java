package com.yisu.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuyisu
 * @description 用户service
 * @date 2021/11/12
 */
@Component
@Slf4j
public class UserService {


    public Map<String,String> getUser(){

        Map<String,String> map=new HashMap<>();
        map.put("id","001");
        map.put("username","bajie");
        map.put("age","29");
        return map;
    }

}
