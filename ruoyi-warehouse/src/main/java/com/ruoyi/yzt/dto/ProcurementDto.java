package com.ruoyi.yzt.dto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProcurementDto {
    /** 采购id */
    private Integer procurementId;

    /** 供应商id */
    private Integer supplierId;

    /** 商品id */
    private Integer productId;

    /** 采购数量 */
    private Integer number;

    /** 单价 */
    private BigDecimal price;

    /** 总价 */
    private BigDecimal totalPrice;

    /** 送货单号 */
    private String oddNumbers;

    /** 入库量 */
    private Integer receipt;

    /** 送货日期 */
    private Date deliveryTime;

    /** 备注 */
    private String procurementNote;

    /**采购状态*/
    private String status;

    /**供应商名称*/
    private String supplierName;

    /**零件名称*/
    private String productName;

    /**入库备注*/
    private String note;

    /**操作人*/
    private String operator;

    /**领取人*/
    private String receivePeople;

    /**记录状态*/
    private String recordStatus;
}
