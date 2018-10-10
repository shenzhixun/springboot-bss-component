package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiDatabaseInfoModel;
public interface IBiDatabaseInfoService { 


	public void insertAutoKey(BiDatabaseInfoModel model) throws CoBusinessException; 

	public void update(BiDatabaseInfoModel model) throws CoBusinessException;

	public void delete(BiDatabaseInfoModel model) throws CoBusinessException; 

	public List<BiDatabaseInfoModel>  queryByCond(BiDatabaseInfoModel model) throws CoBusinessException;


}