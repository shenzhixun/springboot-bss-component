package com.ejet.bss.userinfo.comm;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.global.CoGlobal;
import com.ejet.utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 解析请求的token信息，并从redis或者本地返回用户信息
     *
     * @throws CoBusinessException
     */
    public static String getToken(HttpServletRequest request, CoGlobal global) throws CoBusinessException {
        final String ACCESS_TOKEN_KEY = global.getTokenAuthKey();
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















}
