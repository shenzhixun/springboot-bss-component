package com.ejet.bss.userrights.mapper;

import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.bss.userrights.vo.SysAccountSpecialVO;
import com.ejet.bss.userrights.vo.SysSyslevelVO;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleSyslevelRModel;
@Mapper
public interface SysRoleSyslevelRDao { 


	public void insertSingle(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public void update(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public void delete(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public abstract SysRoleSyslevelRModel  findByPK(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public abstract List<SysRoleSyslevelRModel>  queryByCond(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public abstract List<SysRoleSyslevelRModel>  queryByPage(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public abstract List<SysRoleSyslevelRModel>  queryTree(SysRoleSyslevelRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysRoleSyslevelRModel obj) throws CoBusinessException;


    public abstract List<SysSyslevelModel> listRolesSyslevels(SysSyslevelVO obj) throws CoBusinessException;

    public abstract List<SysSyslevelModel> listRoleSyslevelsSpecial(SysAccountSpecialVO vo) throws CoBusinessException;


}