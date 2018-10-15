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
import com.ejet.bss.userrights.model.SysRoleSyslevelRModel;
import com.ejet.bss.userrights.mapper.SysRoleSyslevelRDao;
import com.ejet.bss.userrights.service.ISysRoleSyslevelRService;
@Service("sysRoleSyslevelRService")
public class SysRoleSyslevelRServiceImpl implements ISysRoleSyslevelRService { 


	private final Logger log = LoggerFactory.getLogger(SysRoleSyslevelRServiceImpl.class);

	@Autowired
	private SysRoleSyslevelRDao mDao;

	@Override
	public void insertAutoKey(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysRoleSyslevelRModel  findByPK(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleSyslevelRModel>  queryByCond(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleSyslevelRModel>  queryByPage(SysRoleSyslevelRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleSyslevelRModel> list = mDao.queryByPage(model);
		PageBean<SysRoleSyslevelRModel> page = new PageBean<SysRoleSyslevelRModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}