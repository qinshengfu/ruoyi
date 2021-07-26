package com.ruoyi.yzt.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class productVO {
    /** 产品id */
    private Integer productId;

    /** 供应商id */
    @Excel(name = "供应商id")
    private Integer supplierId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String model;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Integer inventory;

    /** 图像 */
    @Excel(name = "图像")
    private String image;

    /** 使用状态 */
    @Excel(name = "使用状态")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

}
