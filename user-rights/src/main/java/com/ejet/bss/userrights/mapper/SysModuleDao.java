package com.ejet.bss.userrights.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysModuleModel;
@Mapper
public interface SysModuleDao { 


	public void insertSingle(SysModuleModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysModuleModel obj) throws CoBusinessException; 

	public void update(SysModuleModel obj) throws CoBusinessException; 

	public void delete(SysModuleModel obj) throws CoBusinessException; 

	public abstract SysModuleModel  findByPK(SysModuleModel obj) throws CoBusinessException; 

	public abstract List<SysModuleModel>  queryByCond(SysModuleModel obj) throws CoBusinessException; 

	public abstract List<SysModuleModel>  queryByPage(SysModuleModel obj) throws CoBusinessException; 

	public abstract List<SysModuleModel>  queryTree(SysModuleModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysModuleModel obj) throws CoBusinessException; 


}