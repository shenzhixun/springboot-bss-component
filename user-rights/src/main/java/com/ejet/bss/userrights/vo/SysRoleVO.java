package com.ejet.bss.userrights.vo;

import com.ejet.bss.userrights.model.SysRoleModel;
public class SysRoleVO extends SysRoleModel {
    /**  角色类型名称  */
    private java.lang.String roleTypeName;

    public String getRoleTypeName() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }
}