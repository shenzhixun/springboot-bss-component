package com.ejet.bss.userinfo.comm;

import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.comm.utils.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: LoadResourceUtils
 * Author:   ShenYijie
 * CreateDate:     2018-10-20 20:12
 * Description: 读取yaml文件
 * History:
 * Version: 1.0
 */
public abstract class LoadResourceUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoadResourceUtils.class);

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


}
