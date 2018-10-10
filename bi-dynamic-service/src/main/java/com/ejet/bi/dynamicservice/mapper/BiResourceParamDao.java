package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceParamModel;
@Mapper
public interface BiResourceParamDao { 


	public void insertSingle(BiResourceParamModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiResourceParamModel obj) throws CoBusinessException; 

	public void update(BiResourceParamModel obj) throws CoBusinessException; 

	public void delete(BiResourceParamModel obj) throws CoBusinessException; 

	public abstract BiResourceParamModel  findByPK(BiResourceParamModel obj) throws CoBusinessException; 

	public abstract List<BiResourceParamModel>  queryByCond(BiResourceParamModel obj) throws CoBusinessException; 

	public abstract List<BiResourceParamModel>  queryByPage(BiResourceParamModel obj) throws CoBusinessException; 

	public abstract List<BiResourceParamModel>  queryTree(BiResourceParamModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiResourceParamModel obj) throws CoBusinessException; 


}