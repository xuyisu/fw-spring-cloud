package com.yisu.easyexcel.read.excellistener;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yisu.easyexcel.read.entity.SysUser;
import com.yisu.easyexcel.read.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserExcelListener extends AnalysisEventListener<SysUser> {

    private final SysUserMapper sysUserMapper;

    public  UserExcelListener(SysUserMapper sysUserMapper){
        this.sysUserMapper=sysUserMapper;
    }

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 5;
    List<SysUser> list = new ArrayList<>(BATCH_COUNT);

    @Override
    public void invoke(SysUser sysUser, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSONUtil.toJsonStr(sysUser));
        sysUser.setCreateTime(DateUtil.date());
        sysUser.setUpdateTime(DateUtil.date());
        sysUser.setCreateUser("sys");
        sysUser.setUpdateUser("sys");
        sysUser.setDeleteFlag(0);
        sysUser.setDisableFlag(0);
        list.add(sysUser);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData(){
        log.info("{}条数据，开始存储数据库！", list.size());
        list.stream().forEach(sysUser -> sysUserMapper.insert(sysUser));
        log.info("存储数据库成功！");
    }
}
