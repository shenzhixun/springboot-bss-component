package com.ejet.bss.userinfo.comm;

import com.ejet.bss.userinfo.global.GlobalUserInfo;
import com.ejet.bss.userinfo.service.impl.SysAccountServiceImpl;
import com.ejet.bss.userinfo.vo.SysAccountVO;
import com.ejet.bss.userinfo.vo.SysUserVO;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.des.MD5;
import com.ejet.filter.CoSessionManager;
import com.ejet.global.CoGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: LoginServiceImpl
 * Author:   Ejet
 * CreateDate:     2018-10-09 11:11
 * Description: 登录帮助类
 * History:
 * Version: 1.0
 */

@Service("LoginServiceImplService")
public class LoginServiceImpl {
    @Autowired
    private SysAccountServiceImpl mService;
    @Autowired
    GlobalUserInfo globalUserInfo;
    @Autowired
    CoGlobal global;
    /**
     * 登录返回，用户信息
     * @return
     */
    public SysAccountVO login(HttpServletRequest request, SysAccountVO user) throws CoBusinessException {
        if (!global.isSessionIgnore() && global.isTokenAuth()) { //既基于session认证又token，配置错了
            throw new CoBusinessException(SYS_ERROR, "配置错误，session和token认证重复!");
        }
        if ( user == null ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "用户名为空!"
        }
        if( user.getUserId()==null && StringUtils.isBlank(user.getName()) &&
                StringUtils.isBlank(user.getUserName()) &&
                StringUtils.isBlank(user.getPhone()) &&
                StringUtils.isBlank(user.getIdcard()) ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "用户名为空!"
        }
        if( StringUtils.isBlank(user.getPassword()) ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "密码为空!"
        }
        user.setPassword(MD5.getMD5(user.getPassword())); // 设置为md5值
        SysAccountVO result = mService.login(user);
        if(result==null) {
            throw new CoBusinessException(ExceptionCode.USER_OR_PASSWD_ERROR);//查询失败，用户或密码错误
        }
        if(!global.isSessionIgnore()) { //session认证
            HttpSession session = request.getSession();
            session.setAttribute(CoSessionManager.USER_SESSION_KEY, result);
        }
        if(global.isTokenAuth()) { //token认证
            String token = TokenHelper.createToken();
            result.setToken(token);
            TokenHelper.cacheToken(token, result, globalUserInfo.getAuthTokenTimeout());
        }
        return result;
    }


    /**
     * 退出登录
     *
     * @throws CoBusinessException
     */
    public void logout(HttpServletRequest request, SysAccountVO user) throws CoBusinessException {
        if ( user == null ) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "用户名为空!"
        }
        String authToken = TokenHelper.getToken(request, globalUserInfo.getAuthTokenKey());
        if(!global.isSessionIgnore()) { //session认证
            HttpSession session = request.getSession();
            session.removeAttribute(CoSessionManager.USER_SESSION_KEY);
        }
        if(global.isTokenAuth()) { //token认证
            TokenHelper.delToken(authToken);
        }
    }



}
