package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
public interface ISysAccountRoleRService { 


	public void insertAutoKey(SysAccountRoleRModel model) throws CoBusinessException; 

	public void update(SysAccountRoleRModel model) throws CoBusinessException;

	public void delete(SysAccountRoleRModel model) throws CoBusinessException; 

	public List<SysAccountRoleRModel>  queryByCond(SysAccountRoleRModel model) throws CoBusinessException;


}