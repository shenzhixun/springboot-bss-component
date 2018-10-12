package com.ejet.bi.dynamicservice.comm;

import com.alibaba.druid.pool.DruidDataSource;
import com.ejet.context.CoApplicationContext;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DbExtUtils
 * Author:   Ejet
 * CreateDate:     2018-10-12 19:28
 * Description: 数据库扩展工具
 * History:
 * Version: 1.0
 */
public class DbExtUtils {

    /**
     * 执行sql查询并返回结果
     * @return
     */
    public static List<Map<String,Object>> executeQuery(String dataSourceBeanName, String sql, Object... params) {
        List<Map<String,Object>> list =  new ArrayList<>();
        try {
            DruidDataSource dataSource = (DruidDataSource) CoApplicationContext.getBean(dataSourceBeanName);
            QueryRunner qr = new QueryRunner(dataSource);
            if(params!=null) {
                list = qr.query(sql, new MapListHandler(), params);
            } else {
                list = qr.query(sql, new MapListHandler());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
