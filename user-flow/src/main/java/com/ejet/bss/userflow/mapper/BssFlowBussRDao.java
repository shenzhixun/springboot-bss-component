package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowBussRModel;
@Mapper
public interface BssFlowBussRDao { 


	public void insertSingle(BssFlowBussRModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowBussRModel obj) throws CoBusinessException; 

	public void update(BssFlowBussRModel obj) throws CoBusinessException; 

	public void delete(BssFlowBussRModel obj) throws CoBusinessException; 

	public abstract BssFlowBussRModel  findByPK(BssFlowBussRModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRModel>  queryByCond(BssFlowBussRModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRModel>  queryByPage(BssFlowBussRModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRModel>  queryTree(BssFlowBussRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowBussRModel obj) throws CoBusinessException; 


}