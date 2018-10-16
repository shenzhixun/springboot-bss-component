package com.ejet.bss.userflow.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowBussRModel;
public interface IBssFlowBussRService { 


	public void insertAutoKey(BssFlowBussRModel model) throws CoBusinessException; 

	public void update(BssFlowBussRModel model) throws CoBusinessException;

	public void delete(BssFlowBussRModel model) throws CoBusinessException; 

	public List<BssFlowBussRModel>  queryByCond(BssFlowBussRModel model) throws CoBusinessException;


}