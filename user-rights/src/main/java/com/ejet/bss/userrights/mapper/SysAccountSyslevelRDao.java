package com.ejet.bss.userrights.mapper;

import com.ejet.bss.userrights.model.SysSyslevelModel;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysAccountSyslevelRModel;
@Mapper
public interface SysAccountSyslevelRDao { 


	public void insertSingle(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public void update(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public void delete(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public abstract SysAccountSyslevelRModel  findByPK(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountSyslevelRModel>  queryByCond(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public abstract List<SysAccountSyslevelRModel>  queryByPage(SysAccountSyslevelRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysAccountSyslevelRModel obj) throws CoBusinessException;


    public abstract List<SysSyslevelModel> listAccountSyslevels(SysAccountSyslevelRModel model)throws CoBusinessException;
}