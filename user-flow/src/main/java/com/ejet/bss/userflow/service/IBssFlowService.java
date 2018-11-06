package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowModel;
public interface IBssFlowService { 


	public int insertAutoKey(BssFlowModel model) throws CoBusinessException; 

	public void update(BssFlowModel model) throws CoBusinessException;

	public void delete(BssFlowModel model) throws CoBusinessException; 

	public List<BssFlowModel>  queryByCond(BssFlowModel model) throws CoBusinessException;


}