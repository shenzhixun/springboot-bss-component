package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveApplyModel;
public interface IBssFlowApproveApplyService { 


	public int insertAutoKey(BssFlowApproveApplyModel model) throws CoBusinessException; 

	public void update(BssFlowApproveApplyModel model) throws CoBusinessException;

	public void delete(BssFlowApproveApplyModel model) throws CoBusinessException; 

	public List<BssFlowApproveApplyModel>  queryByCond(BssFlowApproveApplyModel model) throws CoBusinessException;


}