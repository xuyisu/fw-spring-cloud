package com.yisu.redistemplate.util;


import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author xuyisu
 * @date 2019-05-25 21:12
 */
@Component
@Slf4j
public class RedisUtils {
	

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ValueOperations<String, String> valueOperations;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    
    private RedisConnection redisConnection;



    /** 不设置过期时长 */
    public final static long NOT_EXPIRE = -1L;
    
    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: set 根据带项目前缀key 设置value，过期时间默认是永久
     * Description: 
     * @param key
     * @param value
     */
    public void set(String key,Object value){
        set(key, value, NOT_EXPIRE);
    }
    

    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: set 根据key 设置value 需要自己设置是否需要项目前缀和过期时间  
     * Description: 
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key,Object value,long expire){
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

    }

    
    /**
     * 
     * @authorxuyisu 
     * @date  2019-03-19
     * Title: get
     * Description:根据 key 查询value，需要自己设置是否需要项目前缀和过期时间 并转换为对应的clazz 类型
     * @param key
     * @param clazz
     * @param expire
     * @return
     */
    public <T> T get(String key,Class<T> clazz,long expire){
    	Object valueObj = valueOperations.get(key);	//先转成object ,再转string,直接string报int类型转化报错
        String value = valueObj==null?null:valueObj.toString();
        if (expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }
    

    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: get
     * Description: 根据 项目前缀的key 查询value，并转换为对应的clazz 类型，默认过期时间为永久
     * @param key
     * @param clazz
     * @return
     */
    public <T> T get(String key,Class<T> clazz){
        return get(key, clazz, NOT_EXPIRE);
    }
    
    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: get
     * Description: 查询带项目前缀的key的value值，并设过期时间
     * @param key
     * @param expire
     * @return
     */
    public String get(String key,long expire){
       return get(key,expire);
    }
    

    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: get
     * Description: 根据key查询 ，key会加上项目前缀，且过期时间默认为永久
     * @param key
     * @return
     */
    public String get(String key){
        return get(key, NOT_EXPIRE);
    }
    
   
	/**
	 *
	 * @author xuyisu
	 * @date  2019-03-19
	 * Title: delete
	 * Description: 带项目前缀的key删除
	 * @param key
	 */
    public void delete(String key){
        redisTemplate.delete(key);
    }


    /**
     * 
     * @author xuyisu 
     * @date  2019-03-19
     * Title: deleteRaw
     * Description: 原生key的删除 
     * @param key
     */
    public void deleteRaw(String key){
        redisTemplate.delete(key);
    }

    /**
     * 根据匹配删除redis key,如想删除 notify_ 开头的所有key match就为notify_*
     * 
     * @author xuyisu
     * @date 2018年7月18日
     * 
     * @param match
     */
    public void deleteByMatch(String match){
    	redisConnection = redisConnectionFactory.getConnection();
        Cursor<byte[]> cursor = redisConnection.scan(new ScanOptions.ScanOptionsBuilder().match(match).build());
        Set<String> set = new HashSet<String>();
        while (cursor.hasNext()){
            set.add((new String(cursor.next())));
            if (set.size() >= 3000){
                redisTemplate.delete(set);
                set.clear();
            }
        }
        if (set.size() > 0){
            System.out.println(set.size());
            redisTemplate.delete(set);
        }
        redisConnection.close();
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object){
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double || object instanceof Boolean || object instanceof String){
            return String.valueOf(object);
        }
        return JSONUtil.toJsonStr(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json,Class<T> clazz){
        return JSONUtil.toBean(json, clazz);
    }
    




    


}
