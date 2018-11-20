package com.ejet.bss.userinfo.comm;

import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.bss.userinfo.vo.SysAccountVO;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.redis.RedisServiceHelper;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.io.IOUtils;
import com.ejet.context.CoApplicationContext;
import com.ejet.filter.CoSessionManager;
import com.ejet.global.CoGlobal;
import com.ejet.utils.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private static CoGlobal global;
    @Autowired
    private static GlobalUserInfo globalUserInfo;

    static {
        if(redis==null) {
            redis = CoApplicationContext.getBean(RedisServiceHelper.class);
        }
        if(global==null) {
            global = CoApplicationContext.getBean(CoGlobal.class);
        }
        if(globalUserInfo==null) {
            globalUserInfo = CoApplicationContext.getBean(GlobalUserInfo.class);
        }
    }
    /**
     * 解析请求的token信息，并从redis或者本地返回用户信息
     *
     * @throws CoBusinessException
     */
    public static String getToken(HttpServletRequest request) throws CoBusinessException {
        final String ACCESS_TOKEN_KEY = globalUserInfo.getAuthTokenKey();
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
    public static void cacheToken(String tokenKey, SysAccountVO value, int timeOut) {
        redis.put(tokenKey,  value.getUuid(), timeOut, TimeUnit.SECONDS);
        if(globalUserInfo.isAuthTokenSingle()) { //只允许单人登录
            SysAccountVO cacheVo = redis.get(value.getUuid(), SysAccountVO.class);
            if(cacheVo!=null) {
                String oldTokenId = cacheVo.getToken();
                redis.delete(oldTokenId);
                redis.delete(cacheVo.getUuid());
                redis.put(value.getUuid(), value, timeOut, TimeUnit.SECONDS);
            }
        }
    }

    public static void delToken(String tokenKey) {
        if(globalUserInfo.isAuthTokenSingle()) { //只允许单人登录
            String uuid = (String) redis.get(tokenKey);
            if(uuid!=null) {
                redis.delete(uuid);
            }
        }
        redis.delete(tokenKey);
    }


    /**
     * 获取登录账号的uuid
     *
     * @return
     */
    public static String getAccountUuid() {
        String uuid = null;
        try {
            if(global.isTokenAuth()) {
                String tokenId = getToken();
                if(tokenId!=null) {
                    uuid = (String) redis.get(tokenId);
                }
            } if(!global.isSessionIgnore()) { //不忽略session，这时能取到
                HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session = request.getSession();
                Object data = session.getAttribute(CoSessionManager.USER_SESSION_KEY);
                if(data!=null) {
                 uuid = ((SysAccountVO)data).getUuid();
                }
            }
        } catch (CoBusinessException e) {
            logger.error("", e);
        }
        return uuid;
    }


    public static String getToken() throws CoBusinessException {
        String token = null;
        try {
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            token = getToken(request);
        } catch (CoBusinessException e) {
            logger.error("", e);
        }
        return token;
    }

}
