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
import com.ejet.bss.userrights.model.SysOrgzModel;
import com.ejet.bss.userrights.mapper.SysOrgzDao;
import com.ejet.bss.userrights.service.ISysOrgzService;
@Service("sysOrgzService")
public class SysOrgzServiceImpl implements ISysOrgzService { 


	private final Logger log = LoggerFactory.getLogger(SysOrgzServiceImpl.class);

	@Autowired
	private SysOrgzDao mDao;

	@Override
	public void insertAutoKey(SysOrgzModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysOrgzModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysOrgzModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysOrgzModel  findByPK(SysOrgzModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysOrgzModel>  queryByCond(SysOrgzModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysOrgzModel>  queryByPage(SysOrgzModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysOrgzModel> list = mDao.queryByPage(model);
		PageBean<SysOrgzModel> page = new PageBean<SysOrgzModel>(list);
 		return page;
 	}

	public int insertSingle(SysOrgzModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}