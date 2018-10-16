package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowBussRecordModel;
public interface IBssFlowBussRecordService { 


	public void insertAutoKey(BssFlowBussRecordModel model) throws CoBusinessException; 

	public void update(BssFlowBussRecordModel model) throws CoBusinessException;

	public void delete(BssFlowBussRecordModel model) throws CoBusinessException; 

	public List<BssFlowBussRecordModel>  queryByCond(BssFlowBussRecordModel model) throws CoBusinessException;


}