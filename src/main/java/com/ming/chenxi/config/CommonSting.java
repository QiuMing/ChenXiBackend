package com.ming.chenxi.config;

/**
 * Created by Ming on 2016/4/13.
 */
public   enum CommonSting {

    UserNotExist("UserNotExist",1001),
    WrongPassword("WrongPassword",1002),
    UserIsExist("UserIsExist",1003),
    LoginSuccess("LoginSuccess",1004),
    RegisterSuccess("RegisterSuccess",1005),
    MissingParam("MissingParam",1006);

    private String code;

    private int intCode;

    CommonSting(String code, int intCode) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIntCode() {
        return intCode;
    }

    public void setIntCode(int intCode) {
        this.intCode = intCode;
    }
}
