package com.ejet.bss.userinfo.mapper;

import com.ejet.bss.userinfo.vo.SysAccountVO;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;
import java.util.List;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysAccountModel;
@Mapper
public interface SysAccountDao { 


	public void insertSingle(SysAccountModel obj) throws CoBusinessException; 

	public int insertAutoKey(SysAccountModel obj) throws CoBusinessException; 

	public void update(SysAccountModel obj) throws CoBusinessException; 

	public void delete(SysAccountModel obj) throws CoBusinessException; 

	public abstract SysAccountModel  findByPK(SysAccountModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModel>  queryByCond(SysAccountModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModel>  queryByPage(SysAccountModel obj) throws CoBusinessException; 

	public abstract List<SysAccountModel>  queryTree(SysAccountModel obj) throws CoBusinessException; 

	public abstract Integer findMaxId(SysAccountModel obj) throws CoBusinessException;


    public abstract SysAccountVO login(SysAccountModel model) throws CoBusinessException;
}