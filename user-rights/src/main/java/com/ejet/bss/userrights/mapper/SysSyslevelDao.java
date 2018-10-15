package com.ejet.bss.userrights.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysSyslevelModel;
@Mapper
public interface SysSyslevelDao { 


	public void insertSingle(SysSyslevelModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysSyslevelModel obj) throws CoBusinessException; 

	public void update(SysSyslevelModel obj) throws CoBusinessException; 

	public void delete(SysSyslevelModel obj) throws CoBusinessException; 

	public abstract SysSyslevelModel  findByPK(SysSyslevelModel obj) throws CoBusinessException; 

	public abstract List<SysSyslevelModel>  queryByCond(SysSyslevelModel obj) throws CoBusinessException; 

	public abstract List<SysSyslevelModel>  queryByPage(SysSyslevelModel obj) throws CoBusinessException; 

	public abstract List<SysSyslevelModel>  queryTree(SysSyslevelModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(SysSyslevelModel obj) throws CoBusinessException; 


}