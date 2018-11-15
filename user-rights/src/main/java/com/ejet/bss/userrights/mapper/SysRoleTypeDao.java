package com.ejet.bss.userrights.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleTypeModel;
@Mapper
public interface SysRoleTypeDao { 


	public void insertSingle(SysRoleTypeModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysRoleTypeModel obj) throws CoBusinessException; 

	public void update(SysRoleTypeModel obj) throws CoBusinessException; 

	public void delete(SysRoleTypeModel obj) throws CoBusinessException; 

	public abstract SysRoleTypeModel  findByPK(SysRoleTypeModel obj) throws CoBusinessException; 

	public abstract List<SysRoleTypeModel>  queryByCond(SysRoleTypeModel obj) throws CoBusinessException; 

	public abstract List<SysRoleTypeModel>  queryByPage(SysRoleTypeModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysRoleTypeModel obj) throws CoBusinessException; 


}