package com.ejet.bss.userinfo.comm;

import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.redis.RedisServiceHelper;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.io.IOUtils;
import com.ejet.context.CoApplicationContext;
import com.ejet.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: TokenHelper
 * Author:   Ejet
 * CreateDate:     2018-10-08 16:18
 * Description: token信息
 * History:
 * Version: 1.0
 */
public abstract class TokenHelper {
    private static final Logger logger = LoggerFactory.getLogger(TokenHelper.class);
    @Autowired
    private static RedisServiceHelper redis;
    static {
        if(redis==null) {
            redis = CoApplicationContext.getBean(RedisServiceHelper.class);
        }
    }
    /**
     * 解析请求的token信息，并从redis或者本地返回用户信息
     *
     * @throws CoBusinessException
     */
    public static String getToken(HttpServletRequest request, String authTokenKey) throws CoBusinessException {
        final String ACCESS_TOKEN_KEY = authTokenKey;
        String authToken = request.getHeader(ACCESS_TOKEN_KEY);
        if(null == authToken || "".equals(authToken)) {
            authToken = request.getParameter(ACCESS_TOKEN_KEY);
        }
        if(StringUtils.isBlank(authToken)){
            Object token = request.getAttribute(ACCESS_TOKEN_KEY);
            if (token != null)
                authToken = token.toString();
        }
        if(StringUtils.isBlank(authToken)) {
            authToken = CookieUtils.getCookieValue(request, ACCESS_TOKEN_KEY);
        }
        //throw new CoBusinessException(ExceptionCode.SYS_HINT, "Token认证失败!");
        return authToken;
    }

    /**
     * 校验token
     *
     * @return
     */
    public static boolean valdToken() {
        boolean r = false;

        return r;
    }


    /**
     *  生成Token信息
     *
     * @return
     */
    public static String createToken() {
        String token = UuidUtils.getUUID();
        return token;
    }

    /**
     * 缓存token信息
     */
    public static void cacheToken(String tokenKey, Object value, int timeOut) {
        redis.put(tokenKey,  value, timeOut, TimeUnit.SECONDS);
    }

    public static void delToken(String tokenKey) {
        redis.delete(tokenKey);
    }



}
