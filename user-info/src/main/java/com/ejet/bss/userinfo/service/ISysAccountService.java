package com.ejet.bss.userinfo.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysAccountModel;
public interface ISysAccountService { 


	public void insertAutoKey(SysAccountModel model) throws CoBusinessException; 

	public void update(SysAccountModel model) throws CoBusinessException;

	public void delete(SysAccountModel model) throws CoBusinessException; 

	public List<SysAccountModel>  queryByCond(SysAccountModel model) throws CoBusinessException;


}