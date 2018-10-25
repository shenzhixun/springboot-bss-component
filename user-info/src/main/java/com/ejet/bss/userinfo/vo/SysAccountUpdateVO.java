package com.ejet.bss.userinfo.vo;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: SysAccountUpdateVO
 * Author:   ShenYijie
 * CreateDate:     2018-10-24 14:26
 * Description:
 * History:
 * Version: 1.0
 */
public class SysAccountUpdateVO extends SysAccountVO {
    /**
     * 新设置的密码
     */
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
