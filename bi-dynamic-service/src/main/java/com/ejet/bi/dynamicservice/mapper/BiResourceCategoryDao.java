package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceCategoryModel;
@Mapper
public interface BiResourceCategoryDao { 


	public void insertSingle(BiResourceCategoryModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiResourceCategoryModel obj) throws CoBusinessException; 

	public void update(BiResourceCategoryModel obj) throws CoBusinessException; 

	public void delete(BiResourceCategoryModel obj) throws CoBusinessException; 

	public abstract BiResourceCategoryModel  findByPK(BiResourceCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiResourceCategoryModel>  queryByCond(BiResourceCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiResourceCategoryModel>  queryByPage(BiResourceCategoryModel obj) throws CoBusinessException; 

	public abstract List<BiResourceCategoryModel>  queryTree(BiResourceCategoryModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiResourceCategoryModel obj) throws CoBusinessException; 


}