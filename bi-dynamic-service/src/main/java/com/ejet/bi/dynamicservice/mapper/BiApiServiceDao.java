package com.ejet.bi.dynamicservice.mapper;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiServiceModel;
@Mapper
public interface BiApiServiceDao { 


	public void insertSingle(BiApiServiceModel obj) throws CoBusinessException; 

	public int insertAutoKey(BiApiServiceModel obj) throws CoBusinessException; 

	public void update(BiApiServiceModel obj) throws CoBusinessException; 

	public void delete(BiApiServiceModel obj) throws CoBusinessException; 

	public abstract BiApiServiceModel  findByPK(BiApiServiceModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceModel>  queryByCond(BiApiServiceModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceModel>  queryByPage(BiApiServiceModel obj) throws CoBusinessException; 

	public abstract List<BiApiServiceModel>  queryTree(BiApiServiceModel obj) throws CoBusinessException; 

	public abstract Integer  findMaxId(BiApiServiceModel obj) throws CoBusinessException;

    public List<BiApiVO> queryApi(BiApiVO model) throws CoBusinessException;



}