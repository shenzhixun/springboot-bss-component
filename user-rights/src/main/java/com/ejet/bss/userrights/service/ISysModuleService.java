package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysModuleModel;
public interface ISysModuleService { 


	public void insertAutoKey(SysModuleModel model) throws CoBusinessException; 

	public void update(SysModuleModel model) throws CoBusinessException;

	public void delete(SysModuleModel model) throws CoBusinessException; 

	public List<SysModuleModel>  queryByCond(SysModuleModel model) throws CoBusinessException;


}