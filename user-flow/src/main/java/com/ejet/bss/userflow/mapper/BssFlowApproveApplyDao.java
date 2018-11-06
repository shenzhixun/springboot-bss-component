package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveApplyModel;
@Mapper
public interface BssFlowApproveApplyDao { 


	public void insertSingle(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public void update(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public void delete(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public abstract BssFlowApproveApplyModel  findByPK(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveApplyModel>  queryByCond(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveApplyModel>  queryByPage(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveApplyModel>  queryTree(BssFlowApproveApplyModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowApproveApplyModel obj) throws CoBusinessException; 


}