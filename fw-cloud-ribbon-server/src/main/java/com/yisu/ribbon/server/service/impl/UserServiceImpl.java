package com.yisu.ribbon.server.service.impl;

import com.yisu.ribbon.server.entity.User;
import com.yisu.ribbon.server.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        return initUser();
    }

    @Override
    public User getUserById(long id) {
        List<User> userList = getUsers().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(userList)){
            return new User(0,null,null,null,"这位顾客先拿一下腰牌！");
        }
        return userList.get(0);
    }

    private List<User> initUser(){

        List<User> userList =new ArrayList<>();
        User user1=new User(1,"113445","刘备","liubei@gmail.com","汉室刘皇叔,蜀国大佬");
        User user2=new User(2,"123456","关羽","guanyu@gmail.com","人称关二爷,蜀国五虎上将");
        User user3=new User(3,"147258","张飞","zhangfei@gmail.com","此人性格暴躁,蜀国五虎上将");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return  userList;
    }
}
