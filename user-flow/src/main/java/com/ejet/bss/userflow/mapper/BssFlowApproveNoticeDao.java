package com.ejet.bss.userflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowApproveNoticeModel;
@Mapper
public interface BssFlowApproveNoticeDao { 


	public void insertSingle(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public int insertAutoKey(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public void update(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public void delete(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public abstract BssFlowApproveNoticeModel  findByPK(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveNoticeModel>  queryByCond(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveNoticeModel>  queryByPage(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public abstract List<BssFlowApproveNoticeModel>  queryTree(BssFlowApproveNoticeModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BssFlowApproveNoticeModel obj) throws CoBusinessException; 


}