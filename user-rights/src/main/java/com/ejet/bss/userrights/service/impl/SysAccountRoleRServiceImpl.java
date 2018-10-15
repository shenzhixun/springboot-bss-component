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
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.mapper.SysAccountRoleRDao;
import com.ejet.bss.userrights.service.ISysAccountRoleRService;
@Service("sysAccountRoleRService")
public class SysAccountRoleRServiceImpl implements ISysAccountRoleRService { 


	private final Logger log = LoggerFactory.getLogger(SysAccountRoleRServiceImpl.class);

	@Autowired
	private SysAccountRoleRDao mDao;

	@Override
	public void insertAutoKey(SysAccountRoleRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountRoleRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountRoleRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysAccountRoleRModel  findByPK(SysAccountRoleRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountRoleRModel>  queryByCond(SysAccountRoleRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountRoleRModel>  queryByPage(SysAccountRoleRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountRoleRModel> list = mDao.queryByPage(model);
		PageBean<SysAccountRoleRModel> page = new PageBean<SysAccountRoleRModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountRoleRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}