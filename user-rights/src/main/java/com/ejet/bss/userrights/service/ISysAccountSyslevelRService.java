package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountSyslevelRModel;
public interface ISysAccountSyslevelRService { 


	public void insertAutoKey(SysAccountSyslevelRModel model) throws CoBusinessException; 

	public void update(SysAccountSyslevelRModel model) throws CoBusinessException;

	public void delete(SysAccountSyslevelRModel model) throws CoBusinessException; 

	public List<SysAccountSyslevelRModel>  queryByCond(SysAccountSyslevelRModel model) throws CoBusinessException;


}