package com.ejet.bss.userrights;

import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.comm.Param;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: AccountTest
 * Author:   ShenYijie
 * CreateDate:     2018-10-27 23:32
 * Description:
 * History:
 * Version: 1.0
 */
public class AccountTest {

    static Gson gson = new Gson();






    public static void main(String[] args) throws Exception {

        Param<List<SysRoleModel>> param =  new Param<>();
        List<SysRoleModel> list = new ArrayList<>();
        SysRoleModel role = new SysRoleModel();
        role.setRoleId(1);

        SysRoleModel role2 = new SysRoleModel();
        role2.setRoleId(3);

        list.add(role);
        list.add(role2);
        param.setData(list);

        String str =  gson.toJson(param);

        System.out.println(str);
    }



}
