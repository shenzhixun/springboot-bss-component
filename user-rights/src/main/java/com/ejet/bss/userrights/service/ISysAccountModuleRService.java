package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountModuleRModel;
public interface ISysAccountModuleRService { 


	public void insertAutoKey(SysAccountModuleRModel model) throws CoBusinessException; 

	public void update(SysAccountModuleRModel model) throws CoBusinessException;

	public void delete(SysAccountModuleRModel model) throws CoBusinessException; 

	public List<SysAccountModuleRModel>  queryByCond(SysAccountModuleRModel model) throws CoBusinessException;


}