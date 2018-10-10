package com.ejet.bi.dynamicservice;

import com.alibaba.druid.pool.DruidDataSource;
import com.ejet.bi.dynamicservice.service.IBiResourceService;
import com.ejet.bi.dynamicservice.service.impl.BiResourceServiceImpl;
import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.bi.dynamicservice.vo.BiResourceVO;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.context.CoApplicationContext;
import com.ejet.global.CoConstant;
import com.google.gson.Gson;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DynamicUrlHelper
 * Author:   Ejet
 * CreateDate:     2018-10-09 17:04
 * Description: 动态url解析
 * History:
 * Version: 1.0
 */
public class DynamicUrlHelper {

    private static final Logger log = LoggerFactory.getLogger(DynamicUrlHelper.class);
    private static Gson gson = new Gson();
    /**
     * 接口与资源映射缓存
     */
    public static Map<String, BiApiVO> api = new ConcurrentHashMap<>();

    @Autowired
    private static IBiResourceService biResourceService;


    public static void addApis(Map<String, BiApiVO> map) {
        api.putAll(map);
    }

    public static void addApi(String key, BiApiVO vo) {
        api.put(key, vo);
    }

    public static BiApiVO getApi(String uri) {
        if(uri==null) return null;
        return api.get(uri);
    }

    /**
     *
     * @return
     */
    public static List<Map<String,Object>> execute(String dataSourceBeanName, String sql) {
        List<Map<String,Object>> list =  new ArrayList<>();
        try {
            DruidDataSource dataSource = (DruidDataSource) CoApplicationContext.getBean(dataSourceBeanName);
            QueryRunner qr = new QueryRunner(dataSource);
            list = qr.query(sql, new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 返回查询结果信息
     * @param vo
     * @return
     */
    public static String responseBody(BiApiVO vo) {
        String result = "";
        String resourceUuid = vo.getResourceUuid();
        BiResourceVO query = new BiResourceVO();
        query.setUuid(resourceUuid);
        query.setStatus(CoConstant.STATUS_NORMAL);
        Result rs = new Result();
        try {
            if(biResourceService==null) {
                biResourceService = CoApplicationContext.getBean(BiResourceServiceImpl.class);
            }
            BiResourceVO resource = biResourceService.queryResourceByPK(query);
            if(resource!=null) {
                String sql = resource.getSqlContent();
                if(!StringUtils.isBlank(sql)) {
                    List<Map<String, Object>> map = execute(resource.getBeanName(), sql);
                    rs.setData(map);
                }
            }
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        result = gson.toJson(rs);
        return  result;
    }


}
