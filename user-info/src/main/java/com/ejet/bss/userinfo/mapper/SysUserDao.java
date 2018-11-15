package com.ejet.bss.userinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysUserModel;
@Mapper
public interface SysUserDao { 


	public void insertSingle(SysUserModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysUserModel obj) throws CoBusinessException; 

	public void update(SysUserModel obj) throws CoBusinessException; 

	public void delete(SysUserModel obj) throws CoBusinessException; 

	public abstract SysUserModel  findByPK(SysUserModel obj) throws CoBusinessException; 

	public abstract List<SysUserModel>  queryByCond(SysUserModel obj) throws CoBusinessException; 

	public abstract List<SysUserModel>  queryByPage(SysUserModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysUserModel obj) throws CoBusinessException; 


}