package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiServiceModel;
public interface IBiApiServiceService { 


	public void insertAutoKey(BiApiServiceModel model) throws CoBusinessException; 

	public void update(BiApiServiceModel model) throws CoBusinessException;

	public void delete(BiApiServiceModel model) throws CoBusinessException; 

	public List<BiApiServiceModel>  queryByCond(BiApiServiceModel model) throws CoBusinessException;


}