package com.ruoyi.yzt.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    NORMAL("0","正常"),
    DISABLE("1","停用"),
    ;
    private String code;
    private String msg;

    StatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
