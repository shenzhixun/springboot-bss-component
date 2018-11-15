package com.ejet.bss.userrights.mapper;

import com.ejet.bss.userrights.vo.SysAccountRoleRVO;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
@Mapper
public interface SysAccountRoleRDao { 


	public void insertSingle(SysAccountRoleRModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysAccountRoleRModel obj) throws CoBusinessException; 

	public void update(SysAccountRoleRModel obj) throws CoBusinessException; 

	public void delete(SysAccountRoleRModel obj) throws CoBusinessException; 

	public abstract SysAccountRoleRModel  findByPK(SysAccountRoleRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountRoleRModel>  queryByCond(SysAccountRoleRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountRoleRModel>  queryByPage(SysAccountRoleRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysAccountRoleRModel obj) throws CoBusinessException;


	/** 用户对应角色关联 */
    public abstract List<SysAccountRoleRVO> listAccountRoles(SysAccountRoleRVO obj) throws CoBusinessException;


}