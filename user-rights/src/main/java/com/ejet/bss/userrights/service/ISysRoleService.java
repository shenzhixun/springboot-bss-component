package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleModel;
public interface ISysRoleService { 


	public void insertAutoKey(SysRoleModel model) throws CoBusinessException; 

	public void update(SysRoleModel model) throws CoBusinessException;

	public void delete(SysRoleModel model) throws CoBusinessException; 

	public List<SysRoleModel>  queryByCond(SysRoleModel model) throws CoBusinessException;


}