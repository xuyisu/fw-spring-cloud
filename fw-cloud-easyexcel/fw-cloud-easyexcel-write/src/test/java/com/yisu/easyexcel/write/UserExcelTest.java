package com.yisu.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.yisu.easyexcel.write.entity.SysUser;
import com.yisu.easyexcel.write.mapper.SysUserMapper;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserExcelTest {

    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link SysUser}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void testWriteMethod1(){

        String fileName = TestFileUtil.getPath() + System.currentTimeMillis() + "user.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, SysUser.class).sheet("模板").doWrite(initDate());
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link SysUser}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void testWriteMethod2(){

        String fileName = TestFileUtil.getPath() + System.currentTimeMillis() + "user.xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, SysUser.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(initDate(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    /**
     * 写入到不同的sheet
     */
    @Test
    public void testWriteMethodMoreSheet() {
        // 方法3 如果写到不同的sheet 不同的对象
        String fileName = TestFileUtil.getPath() + System.currentTimeMillis() + "user.xlsx";
        // 这里 指定文件
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        List<SysUser> sysUsers = initDate();
        List<List<SysUser>> partition = ListUtils.partition(sysUsers, 5);//分成多份，没份5条数据
        // 去调用写入,这里我调用了多次，这里最终会写到多个sheet里面
        for (int i = 0; i < partition.size(); i++) {
            // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
            WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(SysUser.class).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<SysUser> data = partition.get(i);
            excelWriter.write(data, writeSheet);
        }
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    /**
     * 构造数据
     * @return
     */
    private List<SysUser> initDate(){
        return sysUserMapper.selectList(null);
    }





}
