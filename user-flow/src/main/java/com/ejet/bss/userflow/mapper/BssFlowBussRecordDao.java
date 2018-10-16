package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowBussRecordModel;
@Mapper
public interface BssFlowBussRecordDao { 


	public void insertSingle(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public void update(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public void delete(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public abstract BssFlowBussRecordModel  findByPK(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRecordModel>  queryByCond(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRecordModel>  queryByPage(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public abstract List<BssFlowBussRecordModel>  queryTree(BssFlowBussRecordModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowBussRecordModel obj) throws CoBusinessException; 


}