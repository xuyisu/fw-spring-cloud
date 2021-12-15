package com.yisu.springboot.groovy;

import groovy.lang.Script;

/**
 * @author xuyisu
 * @date 2021/11/12
 */
public class DemoScript extends Script {
    @Override
    public Object run() {
        System.out.println("测试demo......");
        return null;
    }

    public Integer add (Integer first, Integer second) {
        return first + second;
    }
}
