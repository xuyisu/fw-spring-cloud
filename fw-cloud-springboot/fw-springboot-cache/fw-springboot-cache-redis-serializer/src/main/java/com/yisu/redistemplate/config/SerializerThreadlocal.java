package com.yisu.redistemplate.config;


public class SerializerThreadlocal {

    protected static final ThreadLocal<String> LOCAL = new ThreadLocal<>();



    /**
     * 设置本地变量
     *
     * @author xuyisu
     * @date 2019-04-18
     */
    public static void set(String params){
        LOCAL.set(params);
    }

    /**
     * 获取本地变量
     *
     * @author xuyisu
     * @date 2019-04-18
     */
    public static String get(){
        return LOCAL.get()==null?"":LOCAL.get();
    }

    /**
     * 移除本地变量
     *
     * @author xuyisu
     * @date 2019-04-18
     */
    public static void clear(){
        LOCAL.remove();
    }
}
