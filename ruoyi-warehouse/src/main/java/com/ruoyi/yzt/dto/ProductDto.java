package com.ruoyi.yzt.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDto {
    /** 产品id */
    private Integer productId;

    /** 供应商id */
    private Integer supplierId;

    /**供应商名称*/
    private String supplierName;

    /** 产品名称 */
    private String productName;

    /**仓库编码*/
    private String warehouseCode;

    /** 规格型号 */
    private String model;

    /** 单位 */
    private String unit;

    /** 单价 */
    private BigDecimal price;

    /** 库存数量 */
    private Integer inventory;

    /** 图像 */
    private String image;

    /** 使用状态 */
    private String status;

    /** 备注 */
    private String note;



    /**领取人*/
    private String receivePeople;

    /**操作人*/
    private String operator;

    /**出入库数量*/
    private Integer changeNumber;

    /**库存状态*/
    private String recordStatus;

    /**出入库记录备注*/
    private String receiveNote;


    /** 送货单号 */
    private String oddNumbers;

    /** 入库量 */
    private Integer receipt;

    /** 送货日期 */
    private Date deliveryTime;

    /** 备注 */
    private String procurementNote;
}
