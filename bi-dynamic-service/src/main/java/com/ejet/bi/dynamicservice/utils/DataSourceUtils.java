package com.ejet.bi.dynamicservice.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.ejet.bi.dynamicservice.model.BiDatabaseInfoModel;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DataSourceUtils
 * Author:   Ejet
 * CreateDate:     2018-10-09 16:33
 * Description: datasource工具类
 * History:
 * Version: 1.0
 */
public class DataSourceUtils {

    public final static String DRIVER_CLASS_NAME = "driverClassName";
    public final static String URL = "url";
    public final static String USER_NAME = "username";
    public final static String PASSWORD = "password";
    public final static String INITIAL_SIZE = "initialSize";
    public final static String MIN_IDLE = "minIdle";
    public final static String MAX_ACTIVE = "maxActive";
    public final static String MAX_WAIT = "maxWait";
    public final static String TIME_BETWEEN_EVICTION_RUNS_MILLIS = "timeBetweenEvictionRunsMillis";
    public final static String VALIDATION_QUERY = "validationQuery";
    public final static String VALIDATION_QUERY_VALUE = "SELECT 1 FROM DUAL";
    public final static String TEST_WHILE_IDLE = "testWhileIdle";
    public final static String TEST_ON_BORROW  = "testOnBorrow";
    public final static String TEST_ON_RETURN = "testOnReturn";
    public final static String POOL_PREPARED_STATEMENTS = "poolPreparedStatements";
    public final static String MAX_PRE_PER_CONNECTION_SIZE = "maxPoolPreparedStatementPerConnectionSize";
    public final static String FILTERS = "filters";
    public final static String FILTERS_VALUE = "stat";
    public final static String CONNECTION_PROPERTIES = "connectionProperties";
    public final static String CONNECTION_PROPERTIES_VALUE = "druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000";


    public static Map<String, Object> getDruidBeanPropertyValue(BiDatabaseInfoModel db) {
        Map<String, Object> propertyValue = new HashMap<String, Object>();
        propertyValue.put(DRIVER_CLASS_NAME, db.getDbDriver());
        propertyValue.put(URL, db.getDbUrl());
        propertyValue.put(USER_NAME, db.getDbUsername());
        propertyValue.put(PASSWORD, db.getDbPassword());

        propertyValue.put(INITIAL_SIZE, 5);
        propertyValue.put(MIN_IDLE, 5);
        propertyValue.put(MAX_ACTIVE, 20);
        propertyValue.put(MAX_WAIT, 60000);
        propertyValue.put(TIME_BETWEEN_EVICTION_RUNS_MILLIS, 60000);
        propertyValue.put(VALIDATION_QUERY, VALIDATION_QUERY_VALUE);
        propertyValue.put(TEST_WHILE_IDLE, true);
        propertyValue.put(TEST_ON_BORROW, false);
        propertyValue.put(TEST_ON_RETURN, false);
        propertyValue.put(POOL_PREPARED_STATEMENTS, true);
        propertyValue.put(MAX_PRE_PER_CONNECTION_SIZE, 20);
        propertyValue.put(FILTERS, FILTERS_VALUE);
        propertyValue.put(CONNECTION_PROPERTIES, CONNECTION_PROPERTIES_VALUE);
        return propertyValue;
    }

}
