package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;

import com.ejet.global.CoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleTypeModel;
import com.ejet.bss.userrights.mapper.SysRoleTypeDao;
import com.ejet.bss.userrights.service.ISysRoleTypeService;
@Service("sysRoleTypeService")
public class SysRoleTypeServiceImpl implements ISysRoleTypeService { 


	private final Logger log = LoggerFactory.getLogger(SysRoleTypeServiceImpl.class);

	@Autowired
	private SysRoleTypeDao mDao;

	@Override
	public void insertAutoKey(SysRoleTypeModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleTypeModel model) throws CoBusinessException {
        if(model.getId()==null && model.getRoleTypeId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleTypeModel model) throws CoBusinessException {
        if(model.getId()==null && model.getRoleTypeId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
        }
 		mDao.delete(model);
 	}  

	public SysRoleTypeModel  findByPK(SysRoleTypeModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleTypeModel>  queryByCond(SysRoleTypeModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleTypeModel>  queryByPage(SysRoleTypeModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleTypeModel> list = mDao.queryByPage(model);
		PageBean<SysRoleTypeModel> page = new PageBean<SysRoleTypeModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleTypeModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
        model.setRoleTypeId(maxId);
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());

 		mDao.insertSingle(model);
 		return maxId;
 	}


}