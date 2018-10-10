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
import com.ejet.bi.dynamicservice.model.BiDatabaseInfoModel;
import com.ejet.bi.dynamicservice.mapper.BiDatabaseInfoDao;
import com.ejet.bi.dynamicservice.service.IBiDatabaseInfoService;
@Service("biDatabaseInfoService")
public class BiDatabaseInfoServiceImpl implements IBiDatabaseInfoService { 


	private final Logger log = LoggerFactory.getLogger(BiDatabaseInfoServiceImpl.class);

	@Autowired
	private BiDatabaseInfoDao mDao;

	@Override
	public void insertAutoKey(BiDatabaseInfoModel model) throws CoBusinessException { 
 		 mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiDatabaseInfoModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		 mDao.update(model);
 	}  

	@Override
	public void delete(BiDatabaseInfoModel model) throws CoBusinessException { 
 		 mDao.delete(model);
 	}  

	public BiDatabaseInfoModel  findByPK(BiDatabaseInfoModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}  

	@Override
	public List<BiDatabaseInfoModel>  queryByCond(BiDatabaseInfoModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}  

	public PageBean<BiDatabaseInfoModel>  queryByPage(BiDatabaseInfoModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiDatabaseInfoModel> list = mDao.queryByPage(model);
		PageBean<BiDatabaseInfoModel> page = new PageBean<BiDatabaseInfoModel>(list);
 		return page;
 	}  

	public int insertSingle(BiDatabaseInfoModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}