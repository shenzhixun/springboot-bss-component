package com.ejet.bi.dynamicservice.comm;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DynamicDataSource
 * Author:   Ejet
 * CreateDate:     2018-10-14 23:59
 * Description: 动态数据源
 * History:
 * Version: 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBName();
    }
}
