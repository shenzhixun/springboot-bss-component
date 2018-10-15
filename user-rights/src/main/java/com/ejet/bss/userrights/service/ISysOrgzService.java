package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysOrgzModel;
public interface ISysOrgzService { 


	public void insertAutoKey(SysOrgzModel model) throws CoBusinessException; 

	public void update(SysOrgzModel model) throws CoBusinessException;

	public void delete(SysOrgzModel model) throws CoBusinessException; 

	public List<SysOrgzModel>  queryByCond(SysOrgzModel model) throws CoBusinessException;


}