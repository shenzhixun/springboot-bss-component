package com.ejet.bidynamicservice;

import com.ejet.bi.dynamicservice.DynamicUrlHelper;
import com.ejet.bi.dynamicservice.comm.DataSourceContextHolder;
import com.ejet.bi.dynamicservice.service.impl.BiApiServiceServiceImpl;
import com.ejet.bi.dynamicservice.service.impl.BiCommServiceImpl;
import com.ejet.bi.dynamicservice.service.impl.BiResourceServiceImpl;
import com.ejet.bi.dynamicservice.vo.BiApiBO;
import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.bi.dynamicservice.vo.BiResourceVO;
import com.ejet.comm.Page;
import com.ejet.comm.PageBean;
import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.global.CoConstant;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: BiCommServiceTest
 * Author:   Ejet
 * CreateDate:     2018-10-14 16:00
 * Description: 测试通用
 * History:
 * Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BiCommServiceTest {
    @Autowired
    BiApiServiceServiceImpl biApiService;
    @Autowired
    BiResourceServiceImpl biResourceService;
    @Autowired
    private BiCommServiceImpl commService;
    private static Gson gson = new Gson();
    /**
     * 加载api到内存
     */
    @Before
    public void loadApi() {
        try {
            BiApiVO query = new BiApiVO();
            query.setStatus(CoConstant.STATUS_NORMAL);
            Map<String, BiApiBO> map = biApiService.queryApi(query);
            if(map!=null) {
                DynamicUrlHelper.addApis(map);
            }
        } catch (CoBusinessException e) {
            //log.error("注册数据库资源失败", e);
        }finally {

        }
    }


    @Test
    public void queyByPage(){
        try {
            Param param = new Param();
            param.setPage(new Page(1, 4));
            String servletPath = "/api/qlinker";
            BiApiBO vo = DynamicUrlHelper.queryApi(servletPath);

            String result = queryDynamic(vo, param);

            System.out.println(result);

        } catch (CoBusinessException e) {
            e.printStackTrace();
        }
    }





    /**
     * 返回查询结果信息
     *
     * @param vo
     * @return
     */
    public String queryDynamic(BiApiBO vo, Param param) throws CoBusinessException {
        String result = "";
        Result rs = new Result();
        Map<String, Object> data = new HashMap<>();
        try {
            //查询服务下所有sql
            List<BiResourceVO> list = biResourceService.queryResouceBatch(vo.getList());
            if(list!=null) {
                for(BiResourceVO resource : list) {
                    String sql = resource.getSqlContent();
                    DataSourceContextHolder.setDBName(resource.getBeanName());
                    if (!StringUtils.isBlank(sql)) {
                        Map<String, Object> params = new HashMap<>();
                        if(param.getPage()!=null) {
                            PageBean<Map<String, Object>> temp = commService.queryByPage(params, 1, 2);
                            data.put(resource.getName(), temp);
                        } else {

                        }
                    }
                }
            }
            rs.setData(data);
        }catch (CoBusinessException e) {
            //log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        result = gson.toJson(rs);
        return  result;
    }











}
