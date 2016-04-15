package com.ming.chenxi.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Ming on 2016/4/13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileUser extends UserProfile {

    public String phone;

    public String token;

    private String result;

    private String ip;

    private String role;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
