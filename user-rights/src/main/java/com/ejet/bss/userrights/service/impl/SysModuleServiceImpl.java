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
import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.mapper.SysModuleDao;
import com.ejet.bss.userrights.service.ISysModuleService;
@Service("sysModuleService")
public class SysModuleServiceImpl implements ISysModuleService { 


	private final Logger log = LoggerFactory.getLogger(SysModuleServiceImpl.class);

	@Autowired
	private SysModuleDao mDao;

	@Override
	public void insertAutoKey(SysModuleModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysModuleModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysModuleModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysModuleModel  findByPK(SysModuleModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysModuleModel>  queryByCond(SysModuleModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysModuleModel>  queryByPage(SysModuleModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysModuleModel> list = mDao.queryByPage(model);
		PageBean<SysModuleModel> page = new PageBean<SysModuleModel>(list);
 		return page;
 	}

	public int insertSingle(SysModuleModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}