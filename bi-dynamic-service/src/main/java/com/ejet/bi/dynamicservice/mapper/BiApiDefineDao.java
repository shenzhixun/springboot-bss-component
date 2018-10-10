package com.ejet.bi.dynamicservice.mapper;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiDefineModel;
@Mapper
public interface BiApiDefineDao { 


	public void insertSingle(BiApiDefineModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiApiDefineModel obj) throws CoBusinessException; 

	public void update(BiApiDefineModel obj) throws CoBusinessException; 

	public void delete(BiApiDefineModel obj) throws CoBusinessException; 

	public abstract BiApiDefineModel  findByPK(BiApiDefineModel obj) throws CoBusinessException; 

	public abstract List<BiApiDefineModel>  queryByCond(BiApiDefineModel obj) throws CoBusinessException; 

	public abstract List<BiApiDefineModel>  queryByPage(BiApiDefineModel obj) throws CoBusinessException; 

	public abstract List<BiApiDefineModel>  queryTree(BiApiDefineModel obj) throws CoBusinessException; 
	public abstract Integer  findMaxId(BiApiDefineModel obj) throws CoBusinessException;

    public abstract List<BiApiVO> queryApi(BiApiVO obj) throws CoBusinessException;


}