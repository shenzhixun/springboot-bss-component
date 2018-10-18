package com.ejet.bss.userinfo.vo;

import com.ejet.bss.userinfo.model.SysAccountModel;
public class SysAccountVO extends SysAccountModel {
    /**  用户id  */
    private Long userId;
    /**  用户名  */
    private String userName;
    /**  电话号码  */
    private String phone;
    /**  身份证号  */
    private String idcard;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}