package com.yisu.transacation.base.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description 事务日志表-实体
 * @author xuyisu
 * @date '2020-03-26 15:18:19'.
 */
@Data
@TableName("fw_transaction_log")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class FwTransactionLog extends Model<FwTransactionLog> {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 事务id
     */
    private String transactionId;
    /**
     * 备注
     */
    private String remark;
}