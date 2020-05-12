package com.yisu.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.yisu.easyexcel.read.entity.SysUser;
import com.yisu.easyexcel.read.excellistener.UserExcelListener;
import com.yisu.easyexcel.read.mapper.SysUserMapper;
import com.yisu.easyexcel.utils.TestFileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserExcelTest {

    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 读取Excel 中的数据并存入数据库
     */
    @Test
    public void testReadMethod1(){

        String fileName = TestFileUtil.getPath() + "sysUser" + File.separator + "user.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, SysUser.class, new UserExcelListener(sysUserMapper)).sheet().doRead();
    }

    /**
     * 读取Excel 指定sheet 的数据并存入数据库
     */
    @Test
    public void testReadMethod2(){

        String fileName = TestFileUtil.getPath() + "sysUser" + File.separator + "user.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        ExcelReader excelReader = EasyExcel.read(fileName, SysUser.class, new UserExcelListener(sysUserMapper)).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }


    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link SysUser}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UserExcelListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void testReadByAllSheetMethod1(){

        String fileName = TestFileUtil.getPath() + "sysUser" + File.separator + "user.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, SysUser.class, new UserExcelListener(sysUserMapper)).doReadAll();
    }

    /**
     * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link SysUser}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UserExcelListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void testReadByAllSheetMethod2(){

        String fileName = TestFileUtil.getPath() + "sysUser" + File.separator + "user.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
        ReadSheet readSheet0 =
                EasyExcel.readSheet(0).head(SysUser.class).registerReadListener(new UserExcelListener(sysUserMapper)).build();
        ReadSheet readSheet1 =
                EasyExcel.readSheet(1).head(SysUser.class).registerReadListener(new UserExcelListener(sysUserMapper)).build();
        ReadSheet readSheet2 =
                EasyExcel.readSheet(2).head(SysUser.class).registerReadListener(new UserExcelListener(sysUserMapper)).build();
        ReadSheet readSheet3 =
                EasyExcel.readSheet(3).head(SysUser.class).registerReadListener(new UserExcelListener(sysUserMapper)).build();
        // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
        excelReader.read(readSheet0,readSheet1, readSheet2,readSheet3);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }


}
