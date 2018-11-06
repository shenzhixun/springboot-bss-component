package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveDetailModel;
@Mapper
public interface BssFlowApproveDetailDao { 


	public void insertSingle(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public void update(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public void delete(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public abstract BssFlowApproveDetailModel  findByPK(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveDetailModel>  queryByCond(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveDetailModel>  queryByPage(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveDetailModel>  queryTree(BssFlowApproveDetailModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowApproveDetailModel obj) throws CoBusinessException; 


}