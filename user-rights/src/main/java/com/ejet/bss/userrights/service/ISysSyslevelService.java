package com.ejet.bss.userrights.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysSyslevelModel;
public interface ISysSyslevelService { 


	public void insertAutoKey(SysSyslevelModel model) throws CoBusinessException; 

	public void update(SysSyslevelModel model) throws CoBusinessException;

	public void delete(SysSyslevelModel model) throws CoBusinessException; 

	public List<SysSyslevelModel>  queryByCond(SysSyslevelModel model) throws CoBusinessException;


}