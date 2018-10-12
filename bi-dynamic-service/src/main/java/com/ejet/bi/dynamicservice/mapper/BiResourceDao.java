package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceModel;
@Mapper
public interface BiResourceDao { 


	public void insertSingle(BiResourceModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiResourceModel obj) throws CoBusinessException; 

	public void update(BiResourceModel obj) throws CoBusinessException; 

	public void delete(BiResourceModel obj) throws CoBusinessException; 

	public abstract BiResourceModel  findByPK(BiResourceModel obj) throws CoBusinessException; 

	public abstract List<BiResourceModel>  queryByCond(BiResourceModel obj) throws CoBusinessException; 

	public abstract List<BiResourceModel>  queryByPage(BiResourceModel obj) throws CoBusinessException; 

	public abstract List<BiResourceModel>  queryTree(BiResourceModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiResourceModel obj) throws CoBusinessException; 


}