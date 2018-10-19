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
public class TokenHelper {
    private static final Logger logger = LoggerFactory.getLogger(TokenHelper.class);
    private static RedisServiceHelper redis = CoApplicationContext.getBean(RedisServiceHelper.class);
    /**
     * 因为项目没有启动，不能依赖框架自动读取配置
     */
    public static GlobalUserInfo loadTokenAuth() {
        /**
         * application配置必须为以下格式：
        comm-web:
        tokenAuth: true
        sessionIgnore: true
        # 忽略的拦截url地址信息(session过滤器),用‘,’分割
        ignoreURL: /login,/logout
         */
        GlobalUserInfo global = new GlobalUserInfo();
        final String KEY_COMM_WEB = "comm-web";
        final String KEY_COMM_WEB_TOKEN_AUTH = "tokenAuth";

        final String KEY_USER_INFO = "bss-user-info";
        final String KEY_USER_INFO_IGNORE = "authTokenIgnoreURL";
        ClassPathResource resource = new ClassPathResource("application.yml");
        InputStream io = null;
        try {
            io = resource.getInputStream();
            Yaml yaml = new Yaml();
            Map<String, Object> conf = yaml.load(io);
            if(conf!=null && conf.containsKey(KEY_COMM_WEB)) {
                Map<String, Object> commweb = (Map<String, Object>) conf.get(KEY_COMM_WEB);
                if(commweb!=null && commweb.containsKey(KEY_COMM_WEB_TOKEN_AUTH)) {
                   Object token = commweb.get(KEY_COMM_WEB_TOKEN_AUTH);
                    boolean authToken = (token!=null && (Boolean) token);
                    global.setTokenAuth(authToken);
                }
            }
            if(conf!=null && conf.containsKey(KEY_USER_INFO)) {
                Map<String, Object> userinfo = (Map<String, Object>) conf.get(KEY_USER_INFO);
                if(userinfo!=null && userinfo.containsKey(KEY_USER_INFO_IGNORE)) {
                    Object ignores = userinfo.get(KEY_USER_INFO_IGNORE);
                    if(ignores!=null) {
                        String[] arr = ((String)ignores).split(",");
                        global.setAuthTokenIgnoreURL(Arrays.asList(arr));
                    }
                }
            }
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            IOUtils.closeQuietly(io);
        }
        return global;
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
