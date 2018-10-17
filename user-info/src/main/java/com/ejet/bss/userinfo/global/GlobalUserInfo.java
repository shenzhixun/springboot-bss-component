package com.ejet.bss.userinfo.global;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: GlobalUserInfo
 * Author:   ShenYijie
 * CreateDate:     2018-10-17 8:53
 * Description: user-info模块全局配置
 * History:
 * Version: 1.0
 */
@Component
@ConfigurationProperties(prefix="bss-user-info.token")
public class GlobalUserInfo {
    /**
     * token认证字段key信息
     */
    private String authTokenKey;
    /**
     * toekn过期时间
     */
    private Integer authTokenTimeout;

    public String getAuthTokenKey() {
        return authTokenKey;
    }

    public void setAuthTokenKey(String authTokenKey) {
        this.authTokenKey = authTokenKey;
    }

    public Integer getAuthTokenTimeout() {
        return authTokenTimeout;
    }

    public void setAuthTokenTimeout(Integer authTokenTimeout) {
        this.authTokenTimeout = authTokenTimeout;
    }
}
