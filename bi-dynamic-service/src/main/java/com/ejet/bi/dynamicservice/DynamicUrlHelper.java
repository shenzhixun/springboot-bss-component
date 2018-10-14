package com.ejet.bi.dynamicservice;

import com.ejet.bi.dynamicservice.utils.DbExtUtils;
import com.ejet.bi.dynamicservice.service.IBiResourceService;
import com.ejet.bi.dynamicservice.service.impl.BiCommServiceImpl;
import com.ejet.bi.dynamicservice.service.impl.BiResourceServiceImpl;
import com.ejet.bi.dynamicservice.vo.BiApiBO;
import com.ejet.bi.dynamicservice.vo.BiResourceVO;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.context.CoApplicationContext;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
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
    private static DynamicUrlHelper instance;
    /**
     * 接口与资源映射缓存
     */
    private static Map<String, BiApiBO> api = new ConcurrentHashMap<>();

    @Autowired
    private static IBiResourceService biResourceService;

    @Autowired
    private static BiCommServiceImpl biCommService;

    private DynamicUrlHelper() {}

    public static DynamicUrlHelper getInstance() {
        if(instance == null) {
            instance = new DynamicUrlHelper();
        }
        try {
            if(biResourceService==null) {
                instance.biResourceService = CoApplicationContext.getBean(BiResourceServiceImpl.class);
            }
            if(biCommService==null) {
                instance.biCommService = CoApplicationContext.getBean(BiCommServiceImpl.class);
            }
        }catch (Exception e) {
            log.error("", e);
        }
        return instance;
    }
    /**
     * 添加api服务
     * @param map
     */
    public static void addApis(Map<String, BiApiBO> map) {
        getInstance().api.putAll(map);
    }
    public static void addApi(String key, BiApiBO vo) {
        getInstance().api.put(key, vo);
    }

    /**
     * 查询请求的url，是否配置服务
     * @param uri
     * @return
     */
    public static BiApiBO queryApi(String uri) {
        if(uri==null || uri.equals("")) return null;
        return getInstance().api.get(uri);
    }

    public static void init() {

    }


    /**
     * 返回查询结果信息
     *
     * @param vo
     * @return
     */
    public static String queryDynamic(BiApiBO vo) {
        String result = "";
        Result rs = new Result();
        Map<String, Object> data = new HashMap<>();
        try {
            List<BiResourceVO> list = biResourceService.queryResouceBatch(vo.getList());
            if(list!=null) {
                for(BiResourceVO resource : list) {
                    String sql = resource.getSqlContent();
                    if (!StringUtils.isBlank(sql)) {
                        List<Map<String, Object>> map = DbExtUtils.executeQuery(resource.getBeanName(), sql);
                        data.put(resource.getName(), map);
                    }
                }
            }
            rs.setData(data);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        result = gson.toJson(rs);
        return  result;
    }










}
