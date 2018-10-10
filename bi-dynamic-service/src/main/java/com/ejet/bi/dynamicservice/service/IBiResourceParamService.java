package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceParamModel;
public interface IBiResourceParamService { 


	public void insertAutoKey(BiResourceParamModel model) throws CoBusinessException; 

	public void update(BiResourceParamModel model) throws CoBusinessException;

	public void delete(BiResourceParamModel model) throws CoBusinessException; 

	public List<BiResourceParamModel>  queryByCond(BiResourceParamModel model) throws CoBusinessException;


}