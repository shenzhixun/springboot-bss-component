package com.ejet.bss.userinfo.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysUserModel;
public interface ISysUserService { 


	public void insertAutoKey(SysUserModel model) throws CoBusinessException; 

	public void update(SysUserModel model) throws CoBusinessException;

	public void delete(SysUserModel model) throws CoBusinessException; 

	public List<SysUserModel>  queryByCond(SysUserModel model) throws CoBusinessException;


}