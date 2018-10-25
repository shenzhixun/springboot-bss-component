package com.ejet.bss.userrights.vo;

import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.model.SysSyslevelModel;

import java.util.ArrayList;
import java.util.List;

public class SysSyslevelVO extends SysSyslevelModel {
    /**
     * 体系层次
     */
    List<SysSyslevelModel> syslevels = new ArrayList<SysSyslevelModel>();
    /**
     * 账户对应角色信息
     */
    List<SysAccountRoleRModel> accountRoles = new ArrayList<SysAccountRoleRModel>();

    public List<SysSyslevelModel> getSyslevels() {
        return syslevels;
    }

    public void setSyslevels(List<SysSyslevelModel> syslevels) {
        this.syslevels = syslevels;
    }

    public List<SysAccountRoleRModel> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(List<SysAccountRoleRModel> accountRoles) {
        this.accountRoles = accountRoles;
    }
}