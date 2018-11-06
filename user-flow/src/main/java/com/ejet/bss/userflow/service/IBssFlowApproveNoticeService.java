package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveNoticeModel;
public interface IBssFlowApproveNoticeService { 


	public int insertAutoKey(BssFlowApproveNoticeModel model) throws CoBusinessException; 

	public void update(BssFlowApproveNoticeModel model) throws CoBusinessException;

	public void delete(BssFlowApproveNoticeModel model) throws CoBusinessException; 

	public List<BssFlowApproveNoticeModel>  queryByCond(BssFlowApproveNoticeModel model) throws CoBusinessException;


}