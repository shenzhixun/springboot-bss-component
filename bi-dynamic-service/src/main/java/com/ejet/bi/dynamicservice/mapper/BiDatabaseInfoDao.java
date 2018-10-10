package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiDatabaseInfoModel;
@Mapper
public interface BiDatabaseInfoDao { 


	public void insertSingle(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public void update(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public void delete(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public abstract BiDatabaseInfoModel  findByPK(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseInfoModel>  queryByCond(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseInfoModel>  queryByPage(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public abstract List<BiDatabaseInfoModel>  queryTree(BiDatabaseInfoModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiDatabaseInfoModel obj) throws CoBusinessException; 


}