package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiServiceResourceRModel;
public interface IBiApiServiceResourceRService { 


	public void insertAutoKey(BiApiServiceResourceRModel model) throws CoBusinessException; 

	public void update(BiApiServiceResourceRModel model) throws CoBusinessException;

	public void delete(BiApiServiceResourceRModel model) throws CoBusinessException; 

	public List<BiApiServiceResourceRModel>  queryByCond(BiApiServiceResourceRModel model) throws CoBusinessException;


}