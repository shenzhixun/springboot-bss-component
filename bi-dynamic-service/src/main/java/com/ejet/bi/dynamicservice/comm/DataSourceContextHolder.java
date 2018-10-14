package com.ejet.bi.dynamicservice.comm;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DataSourceContextHolder
 * Author:   Ejet
 * CreateDate:     2018-10-14 23:51
 * Description: 数据库切换工具
 * History:
 * Version: 1.0
 */
public class DataSourceContextHolder {
    private final static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDBName(String dbName){
        contextHolder.set(dbName);
    }

    public static String getDBName(){
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}

