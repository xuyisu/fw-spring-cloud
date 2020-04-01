package com.yisu.mongodb.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.yisu.mongodb.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class SysUserServiceTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     */
    @Test
    public void saveTest(){
        mongoTemplate.save(initEntity());
    }
    /**
     * 批量新增
     */
    @Test
    public void saveBatchTest(){
        List<SysUser> list=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(initEntity());
        }
        Collection<SysUser> insert = mongoTemplate.insert(list, SysUser.class);
        log.info("insert 影响行数："+insert.size());
    }
    /**
     * 删除
     */
    @Test
    public void deleteTest(){
        Query query = Query.query(Criteria.where("user_phone").is("48"));
        DeleteResult remove = mongoTemplate.remove(query, SysUser.class);
        log.info("delete 影响行数："+remove.getDeletedCount());
    }
    /**
     * 更新
     */
    @Test
    public void updateTest(){
        Query query = Query.query(Criteria.where("user_phone").is("55"));
        Update update = Update.update("email", "53@qq.com").set("pos_code", "XYS11023");
//        Update update = Update.update("user_phone", "55").set("pos_code", "XYS11023");
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, SysUser.class);
        log.info("update 影响行数："+updateResult.getModifiedCount());
    }


    /**
     * 查询
     */
    @Test
    public void findTest(){
        Query query = Query.query(Criteria.where("user_name").is("root"));
        List<SysUser> sysUsers = mongoTemplate.find(query, SysUser.class);
        System.out.println(sysUsers.size());
        log.info("find 影响行数："+sysUsers.size());
        log.info("find 影响数据："+JSONUtil.toJsonStr(sysUsers));
    }

    /**
     * 构建实体
     */
    private SysUser initEntity(){
        SysUser sysUser=new SysUser();
        sysUser.setId(RandomUtil.randomLong());
        sysUser.setCreateTime(DateUtil.date());
        sysUser.setUpdateTime(DateUtil.date());
        sysUser.setCreateUser("sys");
        sysUser.setUpdateUser("sys");
        sysUser.setDeleteFlag(1);
        sysUser.setDisableFlag(1);
        sysUser.setPosCode("pos");
        sysUser.setAvatar("avatar");
        sysUser.setEmail(RandomUtil.randomNumber()+"@qq.com");
        sysUser.setPassword("123456");
        sysUser.setUserName("root");
        sysUser.setRealName("fwcloud");
        sysUser.setDeptCode("dept");
        sysUser.setUserPhone(String.valueOf(RandomUtil.randomNumber()));

        return sysUser;
    }
}