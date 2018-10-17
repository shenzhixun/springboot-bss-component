package com.ejet.bss.userinfo.service.impl;

import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.bss.userinfo.service.ILoginService;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: LoginServiceImpl
 * Author:   ShenYijie
 * CreateDate:     2018-10-17 11:08
 * Description: 登录处理
 * History:
 * Version: 1.0
 */
public class LoginServiceImpl implements ILoginService {


    @Override
    public void login(SysAccountModel user) throws CoBusinessException {
        if (user==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "用户名或密码为空!"
        }
        if (user.getUserId()==null && StringUtils.isNull(user.getPhone())) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING); // "用户名或密码为空!"
        }





    }

    @Override
    public void logout(SysAccountModel model) throws CoBusinessException {

    }
}
