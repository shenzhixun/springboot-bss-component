package com.ejet.bi.dynamicservice.vo;

import com.ejet.bi.dynamicservice.model.BiResourceModel;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BiResourceVO
 * Author:   Ejet
 * CreateDate:     2018-10-10 14:43
 * Description: sql资源信息
 * History:
 * Version: 1.0
 */
public class BiResourceVO extends BiResourceModel {

    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
