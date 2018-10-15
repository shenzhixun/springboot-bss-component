package com.ejet.bss.userrights.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysOrgzModel;
@Mapper
public interface SysOrgzDao { 


	public void insertSingle(SysOrgzModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysOrgzModel obj) throws CoBusinessException; 

	public void update(SysOrgzModel obj) throws CoBusinessException; 

	public void delete(SysOrgzModel obj) throws CoBusinessException; 

	public abstract SysOrgzModel  findByPK(SysOrgzModel obj) throws CoBusinessException; 

	public abstract List<SysOrgzModel>  queryByCond(SysOrgzModel obj) throws CoBusinessException; 

	public abstract List<SysOrgzModel>  queryByPage(SysOrgzModel obj) throws CoBusinessException; 

	public abstract List<SysOrgzModel>  queryTree(SysOrgzModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysOrgzModel obj) throws CoBusinessException; 


}