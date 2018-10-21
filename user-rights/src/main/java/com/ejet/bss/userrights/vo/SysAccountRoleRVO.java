package com.ejet.bss.userrights.vo;

import com.ejet.bss.userrights.model.SysAccountRoleRModel;
public class SysAccountRoleRVO extends SysAccountRoleRModel {
    /**  角色类型名称  */
    private java.lang.String roleTypeName;
    /**  角色名称  */
    private java.lang.String roleName;

    public String getRoleTypeName() {
        return roleTypeName;
    }

    public void setRoleTypeName(String roleTypeName) {
        this.roleTypeName = roleTypeName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



}