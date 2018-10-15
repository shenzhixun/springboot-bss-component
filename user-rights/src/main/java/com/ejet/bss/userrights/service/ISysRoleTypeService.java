package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleTypeModel;
public interface ISysRoleTypeService { 


	public void insertAutoKey(SysRoleTypeModel model) throws CoBusinessException; 

	public void update(SysRoleTypeModel model) throws CoBusinessException;

	public void delete(SysRoleTypeModel model) throws CoBusinessException; 

	public List<SysRoleTypeModel>  queryByCond(SysRoleTypeModel model) throws CoBusinessException;


}