package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowNodeModel;
public interface IBssFlowNodeService { 


	public void insertAutoKey(BssFlowNodeModel model) throws CoBusinessException; 

	public void update(BssFlowNodeModel model) throws CoBusinessException;

	public void delete(BssFlowNodeModel model) throws CoBusinessException; 

	public List<BssFlowNodeModel>  queryByCond(BssFlowNodeModel model) throws CoBusinessException;


}