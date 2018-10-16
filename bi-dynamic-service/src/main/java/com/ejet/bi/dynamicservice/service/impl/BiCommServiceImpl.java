package com.ejet.bi.dynamicservice.service.impl;

import com.alibaba.druid.support.ibatis.SqlMapExecutorWrapper;
import com.ejet.bi.dynamicservice.mapper.BiApiServiceDao;
import com.ejet.bi.dynamicservice.mapper.BiCommDao;
import com.ejet.bi.dynamicservice.model.BiApiServiceModel;
import com.ejet.comm.PageBean;
import com.ejet.comm.exception.CoBusinessException;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BiCommServiceImpl
 * Author:   Ejet
 * CreateDate:     2018-10-13 14:28
 * Description: 通用service
 * History:
 * Version: 1.0
 */
@Service("biCommService")
public class BiCommServiceImpl {
    private final Logger log = LoggerFactory.getLogger(BiCommServiceImpl.class);

    @Autowired
    private BiCommDao mDao;

    public Object queryByCond(Object obj) throws CoBusinessException {
        SqlMapExecutorWrapper


        return mDao.queryByCond(obj);
    }

    public PageBean<Map<String,Object>> queryByPage(Object obj, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> list = mDao.queryByPage(obj);
        PageBean<Map<String,Object>> page = new PageBean<>(list);
        return page;
    }



}
