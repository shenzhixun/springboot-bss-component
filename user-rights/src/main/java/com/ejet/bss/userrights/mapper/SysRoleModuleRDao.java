package com.ejet.bss.userrights.mapper;

import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysRoleModel;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleModuleRModel;
@Mapper
public interface SysRoleModuleRDao { 


	public void insertSingle(SysRoleModuleRModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysRoleModuleRModel obj) throws CoBusinessException; 

	public void update(SysRoleModuleRModel obj) throws CoBusinessException; 

	public void delete(SysRoleModuleRModel obj) throws CoBusinessException; 

	public abstract SysRoleModuleRModel  findByPK(SysRoleModuleRModel obj) throws CoBusinessException; 

	public abstract List<SysRoleModuleRModel>  queryByCond(SysRoleModuleRModel obj) throws CoBusinessException; 

	public abstract List<SysRoleModuleRModel>  queryByPage(SysRoleModuleRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysRoleModuleRModel obj) throws CoBusinessException;


    public abstract List<SysModuleModel> listRolesModules(List<SysRoleModel> list) throws CoBusinessException;
}