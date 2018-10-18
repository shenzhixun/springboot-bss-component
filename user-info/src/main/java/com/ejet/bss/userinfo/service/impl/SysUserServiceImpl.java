package com.ejet.bss.userinfo.service.impl;

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
import com.ejet.bss.userinfo.model.SysUserModel;
import com.ejet.bss.userinfo.mapper.SysUserDao;
import com.ejet.bss.userinfo.service.ISysUserService;
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService { 


	private final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
	private SysUserDao mDao;

	@Override
	public void insertAutoKey(SysUserModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysUserModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysUserModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysUserModel  findByPK(SysUserModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysUserModel>  queryByCond(SysUserModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysUserModel>  queryByPage(SysUserModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysUserModel> list = mDao.queryByPage(model);
		PageBean<SysUserModel> page = new PageBean<SysUserModel>(list);
 		return page;
 	}

	public int insertSingle(SysUserModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}