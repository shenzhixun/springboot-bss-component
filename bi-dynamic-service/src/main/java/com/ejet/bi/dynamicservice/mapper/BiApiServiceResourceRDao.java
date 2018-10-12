package com.ejet.bi.dynamicservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiServiceResourceRModel;
@Mapper
public interface BiApiServiceResourceRDao { 


	public void insertSingle(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public void update(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public void delete(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public abstract BiApiServiceResourceRModel  findByPK(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceResourceRModel>  queryByCond(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceResourceRModel>  queryByPage(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceResourceRModel>  queryTree(BiApiServiceResourceRModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiApiServiceResourceRModel obj) throws CoBusinessException; 


}