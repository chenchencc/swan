package com.swan.constants;


public enum  RoleEnum {
    WRITE(1,"write"),
    READ(2,"read")
    ;

    private int code;
    private String desc;


    RoleEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
