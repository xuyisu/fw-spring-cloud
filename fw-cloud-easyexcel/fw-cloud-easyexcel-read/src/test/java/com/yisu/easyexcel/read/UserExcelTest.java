package com.yisu.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.yisu.easyexcel.read.entity.SysUser;
import com.yisu.easyexcel.read.excellistener.UserExcelListener;
import com.yisu.easyexcel.utils.TestFileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserExcelTest {


    @Test
    public void testRead(){

        // 写法1：
        String fileName = TestFileUtil.getPath() + "sysUser" + File.separator + "user.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, SysUser.class, new UserExcelListener()).sheet().doRead();
    }


}
