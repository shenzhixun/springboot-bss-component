package com.ejet.bss.userrights;


import com.ejet.bss.userrights.model.SysOrgzModel;
import com.ejet.test.base.BaseTest;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: OrgzTest
 * Author:   ShenYijie
 * CreateDate:     2018-11-05 15:44
 * Description: 组织架构测试
 * History:
 * Version: 1.0
 */
public class OrgzTest extends BaseTest {


    //此处只填写参数，通过eolinker模拟测试

    public static void main(String[] args) {


        SysOrgzModel orgz = new SysOrgzModel();
        orgz.setId(1);
        orgz.setUuid("1");
        orgz.setOrgzId(100001);
        orgz.setOrgzCode("org_root");
        orgz.setOrgzName("集团医院");
        orgz.setFullname("集团医院");
        orgz.setOrgzPid(0);
        orgz.setOrgzLevel(1);
        orgz.setSortOrder(1);
        orgz.setStatus(1);
        orgz.setSearchTag("$1");
        orgz.setRemark("");

        System.out.println(gson.toJson(orgz));

    }




}
