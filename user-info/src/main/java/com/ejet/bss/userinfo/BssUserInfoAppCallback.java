package com.ejet.bss.userinfo;

import com.ejet.bss.userinfo.interceptor.TokenAuthInterceptor;
import com.ejet.configurer.IApplicationBootCallback;
import com.ejet.context.CoApplicationContext;
import com.ejet.global.CoGlobal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BssUserInfoAppCallback
 * Author:   ShenYijie
 * CreateDate:     2018-10-18 21:49
 * Description: 启动回调接口实现
 * History:
 * Version: 1.0
 */
public class BssUserInfoAppCallback implements IApplicationBootCallback {
    private final Logger log = LoggerFactory.getLogger(BssUserInfoAppCallback.class);

    @Override
    public void callApplicationReadyEvent() {
        log.info("======★ [bss-bss-userinfo] callback ... callApplicationReadyEvent ★======");

    }

    @Override
    public void callContextStoppedEvent() {

    }

    @Override
    public void callContextClosedEvent() {

    }

    @Override
    public void callContextRefreshedEvent() {

    }

}
