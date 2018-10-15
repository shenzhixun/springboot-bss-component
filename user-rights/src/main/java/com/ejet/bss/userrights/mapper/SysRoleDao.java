package com.ejet.bss.userrights.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleModel;
@Mapper
public interface SysRoleDao { 


	public void insertSingle(SysRoleModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysRoleModel obj) throws CoBusinessException; 

	public void update(SysRoleModel obj) throws CoBusinessException; 

	public void delete(SysRoleModel obj) throws CoBusinessException; 

	public abstract SysRoleModel  findByPK(SysRoleModel obj) throws CoBusinessException; 

	public abstract List<SysRoleModel>  queryByCond(SysRoleModel obj) throws CoBusinessException; 

	public abstract List<SysRoleModel>  queryByPage(SysRoleModel obj) throws CoBusinessException; 

	public abstract List<SysRoleModel>  queryTree(SysRoleModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysRoleModel obj) throws CoBusinessException; 


}