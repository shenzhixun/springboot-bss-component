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
import com.ejet.bss.userinfo.model.SysUserEavModel;
import com.ejet.bss.userinfo.mapper.SysUserEavDao;
import com.ejet.bss.userinfo.service.ISysUserEavService;
@Service("sysUserEavService")
public class SysUserEavServiceImpl implements ISysUserEavService { 


	private final Logger log = LoggerFactory.getLogger(SysUserEavServiceImpl.class);

	@Autowired
	private SysUserEavDao mDao;

	@Override
	public void insertAutoKey(SysUserEavModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysUserEavModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysUserEavModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysUserEavModel  findByPK(SysUserEavModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysUserEavModel>  queryByCond(SysUserEavModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysUserEavModel>  queryByPage(SysUserEavModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysUserEavModel> list = mDao.queryByPage(model);
		PageBean<SysUserEavModel> page = new PageBean<SysUserEavModel>(list);
 		return page;
 	}

	public int insertSingle(SysUserEavModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}