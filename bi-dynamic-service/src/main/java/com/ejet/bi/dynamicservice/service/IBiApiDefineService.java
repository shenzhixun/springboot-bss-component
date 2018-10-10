package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiDefineModel;
public interface IBiApiDefineService { 


	public void insertAutoKey(BiApiDefineModel model) throws CoBusinessException; 

	public void update(BiApiDefineModel model) throws CoBusinessException;

	public void delete(BiApiDefineModel model) throws CoBusinessException; 

	public List<BiApiDefineModel>  queryByCond(BiApiDefineModel model) throws CoBusinessException;


}