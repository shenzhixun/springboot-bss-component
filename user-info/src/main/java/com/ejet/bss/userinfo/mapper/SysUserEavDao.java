package com.ejet.bss.userinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysUserEavModel;
@Mapper
public interface SysUserEavDao { 


	public void insertSingle(SysUserEavModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysUserEavModel obj) throws CoBusinessException; 

	public void update(SysUserEavModel obj) throws CoBusinessException; 

	public void delete(SysUserEavModel obj) throws CoBusinessException; 

	public abstract SysUserEavModel  findByPK(SysUserEavModel obj) throws CoBusinessException; 

	public abstract List<SysUserEavModel>  queryByCond(SysUserEavModel obj) throws CoBusinessException; 

	public abstract List<SysUserEavModel>  queryByPage(SysUserEavModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysUserEavModel obj) throws CoBusinessException; 


}