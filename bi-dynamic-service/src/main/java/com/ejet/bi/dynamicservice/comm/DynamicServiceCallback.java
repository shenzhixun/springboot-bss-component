package com.ejet.bi.dynamicservice.comm;

import com.alibaba.druid.pool.DruidDataSource;
import com.ejet.bi.dynamicservice.DynamicBeanFactory;
import com.ejet.bi.dynamicservice.DynamicUrlHelper;
import com.ejet.bi.dynamicservice.model.BiDatabaseInfoModel;
import com.ejet.bi.dynamicservice.service.impl.BiApiDefineServiceImpl;
import com.ejet.bi.dynamicservice.service.impl.BiDatabaseInfoServiceImpl;
import com.ejet.bi.dynamicservice.utils.DataSourceUtils;
import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.configurer.IApplicationBootCallback;
import com.ejet.context.CoApplicationContext;
import com.ejet.global.CoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DynamicServiceCallback
 * Author:   Ejet
 * CreateDate:     2018-10-09 15:50
 * Description: 启动回调接口
 * History:
 * Version: 1.0
 */
public class DynamicServiceCallback implements IApplicationBootCallback {
    private final Logger log = LoggerFactory.getLogger(DynamicServiceCallback.class);
    @Autowired
    BiDatabaseInfoServiceImpl biDatabaseInfoService;
    @Autowired
    BiApiDefineServiceImpl biApiDefineService;

    @Override
    public void callApplicationReadyEvent() {
        log.info("======   ★启动应用完成callApplicationReadyEvent★   ======");
        try {
            if(biDatabaseInfoService==null) {
                biDatabaseInfoService = CoApplicationContext.getBean(BiDatabaseInfoServiceImpl.class);
            }
            if(biApiDefineService==null) {
                biApiDefineService = CoApplicationContext.getBean(BiApiDefineServiceImpl.class);
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    registerDatabase();
                }
            }).start();

            loadApi();

        } catch (Exception e) {
            log.error("======   ★启动应用完成callApplicationReadyEvent★   ======", e);
        }
    }

    /**
     * 动态注册database
     */
    public void registerDatabase() {
        try {
            BiDatabaseInfoModel query = new BiDatabaseInfoModel();
            query.setStatus(CoConstant.STATUS_NORMAL);
            List<BiDatabaseInfoModel> list = biDatabaseInfoService.queryByCond(query);
            if(list!=null) {
                for (BiDatabaseInfoModel item : list) {
                    Map<String, Object> propertyValue = DataSourceUtils.getDruidBeanPropertyValue(item);
                    DynamicBeanFactory.registerBean(DruidDataSource.class, item.getName(), propertyValue);
                }
            }
        } catch (CoBusinessException e) {
            log.error("注册数据库资源失败", e);
        }finally {

        }
    }


    /**
     * 加载api到内存
     */
    public void loadApi() {
        try {
            BiApiVO query = new BiApiVO();
            query.setStatus(CoConstant.STATUS_NORMAL);
            List<BiApiVO> list = biApiDefineService.queryApi(query);
            if(list!=null) {
                for (BiApiVO item : list) {
                    String key = item.getPath();
                    if(key!=null && !"".equals(key.trim())) {
                        DynamicUrlHelper.addApi(key, item);
                    }
                }
            }
        } catch (CoBusinessException e) {
            log.error("注册数据库资源失败", e);
        }finally {

        }
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
