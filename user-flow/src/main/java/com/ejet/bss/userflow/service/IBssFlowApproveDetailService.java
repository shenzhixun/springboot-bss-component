package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveDetailModel;
public interface IBssFlowApproveDetailService { 


	public int insertAutoKey(BssFlowApproveDetailModel model) throws CoBusinessException; 

	public void update(BssFlowApproveDetailModel model) throws CoBusinessException;

	public void delete(BssFlowApproveDetailModel model) throws CoBusinessException; 

	public List<BssFlowApproveDetailModel>  queryByCond(BssFlowApproveDetailModel model) throws CoBusinessException;


}