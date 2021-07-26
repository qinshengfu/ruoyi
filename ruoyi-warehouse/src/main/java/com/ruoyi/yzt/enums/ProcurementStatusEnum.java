package com.ruoyi.yzt.enums;

import lombok.Getter;

@Getter
public enum ProcurementStatusEnum {
    ORDER("0","已下单"),
    WAREHOUSE("0","已入库"),
    RETURN_GOODS("3","已退货"),
    ;
    private String code;
    private String msg;

    ProcurementStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
