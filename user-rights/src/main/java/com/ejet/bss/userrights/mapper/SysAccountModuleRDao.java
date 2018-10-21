package com.ejet.bss.userrights.mapper;

import com.ejet.bss.userrights.model.SysModuleModel;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountModuleRModel;
@Mapper
public interface SysAccountModuleRDao { 


	public void insertSingle(SysAccountModuleRModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysAccountModuleRModel obj) throws CoBusinessException; 

	public void update(SysAccountModuleRModel obj) throws CoBusinessException; 

	public void delete(SysAccountModuleRModel obj) throws CoBusinessException; 

	public abstract SysAccountModuleRModel  findByPK(SysAccountModuleRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModuleRModel>  queryByCond(SysAccountModuleRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModuleRModel>  queryByPage(SysAccountModuleRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModuleRModel>  queryTree(SysAccountModuleRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysAccountModuleRModel obj) throws CoBusinessException;


    public abstract List<SysModuleModel> listAccountModules(SysAccountModuleRModel model) throws CoBusinessException;
}