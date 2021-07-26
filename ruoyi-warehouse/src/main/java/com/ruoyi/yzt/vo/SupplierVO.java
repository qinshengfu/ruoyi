package com.ruoyi.yzt.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class SupplierVO {
    /** 供应商id */
    private Integer supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;
}
