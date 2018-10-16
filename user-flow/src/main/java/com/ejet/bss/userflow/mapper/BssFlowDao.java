package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowModel;
@Mapper
public interface BssFlowDao { 


	public void insertSingle(BssFlowModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowModel obj) throws CoBusinessException; 

	public void update(BssFlowModel obj) throws CoBusinessException; 

	public void delete(BssFlowModel obj) throws CoBusinessException; 

	public abstract BssFlowModel  findByPK(BssFlowModel obj) throws CoBusinessException; 

	public abstract List<BssFlowModel>  queryByCond(BssFlowModel obj) throws CoBusinessException; 

	public abstract List<BssFlowModel>  queryByPage(BssFlowModel obj) throws CoBusinessException; 

	public abstract List<BssFlowModel>  queryTree(BssFlowModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowModel obj) throws CoBusinessException; 


}