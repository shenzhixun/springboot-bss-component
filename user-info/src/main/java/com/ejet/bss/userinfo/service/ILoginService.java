package com.ejet.bss.userinfo.service;

import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.comm.exception.CoBusinessException;

import java.util.List;

public interface ILoginService {

	public void login(SysAccountModel model) throws CoBusinessException;

	public void logout(SysAccountModel model) throws CoBusinessException;

}