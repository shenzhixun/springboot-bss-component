package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiDatabaseConfigModel;
public interface IBiDatabaseConfigService { 


	public void insertAutoKey(BiDatabaseConfigModel model) throws CoBusinessException; 

	public void update(BiDatabaseConfigModel model) throws CoBusinessException;

	public void delete(BiDatabaseConfigModel model) throws CoBusinessException; 

	public List<BiDatabaseConfigModel>  queryByCond(BiDatabaseConfigModel model) throws CoBusinessException;


}