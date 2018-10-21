package com.ejet.bss.userrights.vo;

import com.ejet.bss.userrights.model.SysAccountRoleRModel;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: SysAccountSpecialVO
 * Author:   ShenYijie
 * CreateDate:     2018-10-22 0:46
 * Description:
 * History:
 * Version: 1.0
 */
public class SysAccountSpecialVO extends SysAccountRoleRVO {
    /**  体系类型  */
    private java.lang.Integer syslevelType;

    public Integer getSyslevelType() {
        return syslevelType;
    }

    public void setSyslevelType(Integer syslevelType) {
        this.syslevelType = syslevelType;
    }
}
