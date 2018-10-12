package com.ejet.bi.dynamicservice.service.impl;

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
import com.ejet.bi.dynamicservice.model.BiDatabaseConfigModel;
import com.ejet.bi.dynamicservice.mapper.BiDatabaseConfigDao;
import com.ejet.bi.dynamicservice.service.IBiDatabaseConfigService;
@Service("biDatabaseConfigService")
public class BiDatabaseConfigServiceImpl implements IBiDatabaseConfigService { 


	private final Logger log = LoggerFactory.getLogger(BiDatabaseConfigServiceImpl.class);

	@Autowired
	private BiDatabaseConfigDao mDao;

	@Override
	public void insertAutoKey(BiDatabaseConfigModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiDatabaseConfigModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiDatabaseConfigModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiDatabaseConfigModel  findByPK(BiDatabaseConfigModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiDatabaseConfigModel>  queryByCond(BiDatabaseConfigModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiDatabaseConfigModel>  queryByPage(BiDatabaseConfigModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiDatabaseConfigModel> list = mDao.queryByPage(model);
		PageBean<BiDatabaseConfigModel> page = new PageBean<BiDatabaseConfigModel>(list);
 		return page;
 	}

	public int insertSingle(BiDatabaseConfigModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}