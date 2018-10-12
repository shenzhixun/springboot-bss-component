package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiDatabaseConfigModel;
@Mapper
public interface BiDatabaseConfigDao { 


	public void insertSingle(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public void update(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public void delete(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public abstract BiDatabaseConfigModel  findByPK(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseConfigModel>  queryByCond(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseConfigModel>  queryByPage(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseConfigModel>  queryTree(BiDatabaseConfigModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiDatabaseConfigModel obj) throws CoBusinessException; 


}