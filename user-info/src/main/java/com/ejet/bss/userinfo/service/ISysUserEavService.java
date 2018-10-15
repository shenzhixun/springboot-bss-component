package com.ejet.bss.userinfo.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysUserEavModel;
public interface ISysUserEavService { 


	public void insertAutoKey(SysUserEavModel model) throws CoBusinessException; 

	public void update(SysUserEavModel model) throws CoBusinessException;

	public void delete(SysUserEavModel model) throws CoBusinessException; 

	public List<SysUserEavModel>  queryByCond(SysUserEavModel model) throws CoBusinessException;


}