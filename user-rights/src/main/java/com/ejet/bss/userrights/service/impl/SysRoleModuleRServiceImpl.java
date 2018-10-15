package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysRoleModuleRModel;
import com.ejet.bss.userrights.mapper.SysRoleModuleRDao;
import com.ejet.bss.userrights.service.ISysRoleModuleRService;
@Service("sysRoleModuleRService")
public class SysRoleModuleRServiceImpl implements ISysRoleModuleRService { 


	private final Logger log = LoggerFactory.getLogger(SysRoleModuleRServiceImpl.class);

	@Autowired
	private SysRoleModuleRDao mDao;

	@Override
	public void insertAutoKey(SysRoleModuleRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleModuleRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleModuleRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysRoleModuleRModel  findByPK(SysRoleModuleRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleModuleRModel>  queryByCond(SysRoleModuleRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleModuleRModel>  queryByPage(SysRoleModuleRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleModuleRModel> list = mDao.queryByPage(model);
		PageBean<SysRoleModuleRModel> page = new PageBean<SysRoleModuleRModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleModuleRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}