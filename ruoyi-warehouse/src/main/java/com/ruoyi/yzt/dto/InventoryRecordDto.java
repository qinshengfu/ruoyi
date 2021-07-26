package com.ruoyi.yzt.dto;
import lombok.Data;

import java.util.Date;

@Data
public class InventoryRecordDto {
    /** 库存记录id */
    private Integer inventoryRecordId;

    /** 供应商id */
    private Integer supplierId;

    /** 产品id */
    private Integer productId;

    /** 记录时间 */
    private Date recordTime;

    /** 操作人员 */
    private String operator;

    /** 入/出库数量 */
    private Integer changeNumber;

    /** 记录状态 */
    private String recordStatus;

    /** 备注 */
    private String note;

    /** 领取人 */
    private String receivePeople;

    /**产品名称*/
    private String productName;

    /**供应商名称*/
    private String supplierName;
}
