package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleModuleRModel;
public interface ISysRoleModuleRService { 


	public void insertAutoKey(SysRoleModuleRModel model) throws CoBusinessException; 

	public void update(SysRoleModuleRModel model) throws CoBusinessException;

	public void delete(SysRoleModuleRModel model) throws CoBusinessException; 

	public List<SysRoleModuleRModel>  queryByCond(SysRoleModuleRModel model) throws CoBusinessException;


}