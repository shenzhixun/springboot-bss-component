package com.ejet.bi.dynamicservice;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.interceptor.InterceptorBase;
import com.ejet.utils.HttpServletResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: DynamicInterceptor
 * Author:   Ejet
 * CreateDate:     2018-10-08 17:55
 * Description: url地址动态拦截器
 * History:
 * Version: 1.0
 */
public class DynamicInterceptor extends InterceptorBase {

    private final Logger logger = LoggerFactory.getLogger(DynamicInterceptor.class);
    @Override
    public String[] excludePathPatterns() {
        return new String[0];
    }

    //回值为false，当preHandle的返回值为false的时候整个请求就结束了。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        BiApiVO vo = DynamicUrlHelper.getApi(servletPath);
        logger.info("===★uri:{}",  uri);
        logger.info("===★url:{}",  url);
        logger.info("===★contextPath:{}",  contextPath);
        logger.info("===★servletPath:{}",  servletPath);
        logger.info("===★vo:{}",  vo==null? null : vo.getName());
        if(vo!=null) {
            String result = DynamicUrlHelper.responseBody(vo);
            HttpServletResponseUtils.writeResponse(result, "utf-8", response);
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }



}
