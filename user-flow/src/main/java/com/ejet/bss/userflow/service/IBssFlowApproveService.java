package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveModel;
public interface IBssFlowApproveService { 


	public void insertAutoKey(BssFlowApproveModel model) throws CoBusinessException; 

	public void update(BssFlowApproveModel model) throws CoBusinessException;

	public void delete(BssFlowApproveModel model) throws CoBusinessException; 

	public List<BssFlowApproveModel>  queryByCond(BssFlowApproveModel model) throws CoBusinessException;


}