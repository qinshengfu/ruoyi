package com.ruoyi.yzt.enums;

import lombok.Getter;

@Getter
public enum RecordStatusEnum {
    WAREHOUSE("0","入库"),
    DELIVERY("1","出库"),
    RETURN_GOODS("3","退货"),
    ;
    private String code;
    private String msg;

    RecordStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
