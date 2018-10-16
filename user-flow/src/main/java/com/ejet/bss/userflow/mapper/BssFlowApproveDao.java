package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveModel;
@Mapper
public interface BssFlowApproveDao { 


	public void insertSingle(BssFlowApproveModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowApproveModel obj) throws CoBusinessException; 

	public void update(BssFlowApproveModel obj) throws CoBusinessException; 

	public void delete(BssFlowApproveModel obj) throws CoBusinessException; 

	public abstract BssFlowApproveModel  findByPK(BssFlowApproveModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveModel>  queryByCond(BssFlowApproveModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveModel>  queryByPage(BssFlowApproveModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveModel>  queryTree(BssFlowApproveModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowApproveModel obj) throws CoBusinessException; 


}