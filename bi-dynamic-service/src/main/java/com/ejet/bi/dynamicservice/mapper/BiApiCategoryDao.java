package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiCategoryModel;
@Mapper
public interface BiApiCategoryDao { 


	public void insertSingle(BiApiCategoryModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiApiCategoryModel obj) throws CoBusinessException; 

	public void update(BiApiCategoryModel obj) throws CoBusinessException; 

	public void delete(BiApiCategoryModel obj) throws CoBusinessException; 

	public abstract BiApiCategoryModel  findByPK(BiApiCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiApiCategoryModel>  queryByCond(BiApiCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiApiCategoryModel>  queryByPage(BiApiCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiApiCategoryModel>  queryTree(BiApiCategoryModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiApiCategoryModel obj) throws CoBusinessException; 


}