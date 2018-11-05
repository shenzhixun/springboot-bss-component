package com.ejet.bss.userrights;

import com.ejet.bss.userrights.comm.ConstantUserRights;
import com.ejet.bss.userrights.model.SysAccountModuleRModel;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.model.SysAccountSyslevelRModel;
import com.ejet.global.CoConstant;
import com.google.gson.Gson;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: ApiBaseTest
 * Author:   ShenYijie
 * CreateDate:     2018-10-27 23:32
 * Description:
 * History:
 * Version: 1.0
 */
public class ApiBaseTest {

    public static final Integer ROLE_TYPE_ADMIN = 1;
    public static final Integer ROLE_TYPE_DEPT_MANAGER = 2;
    public static final Integer ROLE_TYPE_EMPLOYEE = 3; //
    public static Gson gson = new Gson();


    public static SysAccountRoleRModel sysAccountRoleRModel(String accountUuid, Integer roleId) {
        SysAccountRoleRModel model = new SysAccountRoleRModel();
        model.setAccountUuid(accountUuid);

        model.setRoleTypeId(ROLE_TYPE_EMPLOYEE);
        model.setRoleId(roleId);
        model.setStatus(CoConstant.STATUS_NORMAL);
        return model;
    }

    public static SysAccountModuleRModel sysAccountModuleRModel(String accountUuid, Integer moduleId) {
        SysAccountModuleRModel model = new SysAccountModuleRModel();
        model.setAccountUuid(accountUuid);

        model.setModuleType(ConstantUserRights.MODULE_TYPE_MENU);
        model.setModuleId(moduleId);
        model.setStatus(CoConstant.STATUS_NORMAL);
        return model;
    }


    public static SysAccountSyslevelRModel sysAccountSyslevelRModel(String accountUuid, Integer syslevelId) {
        SysAccountSyslevelRModel model = new SysAccountSyslevelRModel();
        model.setAccountUuid(accountUuid);

        model.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_DEPT);
        model.setSyslevelId(syslevelId);
        model.setStatus(CoConstant.STATUS_NORMAL);
        return model;
    }




    public static SysAccountModuleRModel sysAccountModuleRModel(Integer moduleId) {
        SysAccountModuleRModel model = new SysAccountModuleRModel();
        model.setModuleType(ConstantUserRights.MODULE_TYPE_MENU);
        model.setModuleId(moduleId);
        model.setStatus(CoConstant.STATUS_NORMAL);
        return model;
    }



}
