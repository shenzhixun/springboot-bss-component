package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleSyslevelRModel;
public interface ISysRoleSyslevelRService { 


	public void insertAutoKey(SysRoleSyslevelRModel model) throws CoBusinessException; 

	public void update(SysRoleSyslevelRModel model) throws CoBusinessException;

	public void delete(SysRoleSyslevelRModel model) throws CoBusinessException; 

	public List<SysRoleSyslevelRModel>  queryByCond(SysRoleSyslevelRModel model) throws CoBusinessException;


}