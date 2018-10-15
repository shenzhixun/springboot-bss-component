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
import com.ejet.bss.userrights.model.SysAccountSyslevelRModel;
import com.ejet.bss.userrights.mapper.SysAccountSyslevelRDao;
import com.ejet.bss.userrights.service.ISysAccountSyslevelRService;
@Service("sysAccountSyslevelRService")
public class SysAccountSyslevelRServiceImpl implements ISysAccountSyslevelRService { 


	private final Logger log = LoggerFactory.getLogger(SysAccountSyslevelRServiceImpl.class);

	@Autowired
	private SysAccountSyslevelRDao mDao;

	@Override
	public void insertAutoKey(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysAccountSyslevelRModel  findByPK(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountSyslevelRModel>  queryByCond(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountSyslevelRModel>  queryByPage(SysAccountSyslevelRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountSyslevelRModel> list = mDao.queryByPage(model);
		PageBean<SysAccountSyslevelRModel> page = new PageBean<SysAccountSyslevelRModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountSyslevelRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}