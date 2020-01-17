package com.yisu.cache.redis.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.yisu.cache.redis.entity.User;
import com.yisu.cache.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyisu
 * @description User接口实现
 * @date 2019/12/11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public User getUserById(long id) {
        String userRedis = redisTemplate.opsForValue().get(String.valueOf(id));
        if(StrUtil.isEmpty(userRedis)){
            User userByDao = getUserByDao(id);
            if(null!=userByDao){
                redisTemplate.opsForValue().set(String.valueOf(id),JSONUtil.toJsonStr(userByDao));
                return  userByDao;
            }else{
                return null;
            }
        }else{
            log.info("我是缓存的，有点叼");
            return JSONUtil.toBean(userRedis,User.class);
        }
    }

    private User getUserByDao(long id) {
        List<User> userList = initUser().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(userList)) {
            return new User(0, null, null, null, "这位顾客先拿一下腰牌！");
        }
        log.info("我是非缓存的，请多指教");
        return userList.get(0);
    }

    /**
     * 模拟数据库初始化数据
     *
     * @return
     */
    private List<User> initUser() {

        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "113445", "刘备", "liubei@gmail.com", "汉室刘皇叔,蜀国大佬");
        User user2 = new User(2, "123456", "关羽", "guanyu@gmail.com", "人称关二爷,蜀国五虎上将");
        User user3 = new User(3, "147258", "张飞", "zhangfei@gmail.com", "此人性格暴躁,蜀国五虎上将");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
