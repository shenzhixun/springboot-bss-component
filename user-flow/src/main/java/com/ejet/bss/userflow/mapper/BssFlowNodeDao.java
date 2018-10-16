package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowNodeModel;
@Mapper
public interface BssFlowNodeDao { 


	public void insertSingle(BssFlowNodeModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowNodeModel obj) throws CoBusinessException; 

	public void update(BssFlowNodeModel obj) throws CoBusinessException; 

	public void delete(BssFlowNodeModel obj) throws CoBusinessException; 

	public abstract BssFlowNodeModel  findByPK(BssFlowNodeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowNodeModel>  queryByCond(BssFlowNodeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowNodeModel>  queryByPage(BssFlowNodeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowNodeModel>  queryTree(BssFlowNodeModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowNodeModel obj) throws CoBusinessException; 


}