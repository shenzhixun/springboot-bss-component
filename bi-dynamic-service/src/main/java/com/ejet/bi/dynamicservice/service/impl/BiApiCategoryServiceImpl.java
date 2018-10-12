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
import com.ejet.bi.dynamicservice.model.BiApiCategoryModel;
import com.ejet.bi.dynamicservice.mapper.BiApiCategoryDao;
import com.ejet.bi.dynamicservice.service.IBiApiCategoryService;
@Service("biApiCategoryService")
public class BiApiCategoryServiceImpl implements IBiApiCategoryService { 


	private final Logger log = LoggerFactory.getLogger(BiApiCategoryServiceImpl.class);

	@Autowired
	private BiApiCategoryDao mDao;

	@Override
	public void insertAutoKey(BiApiCategoryModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiApiCategoryModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiApiCategoryModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiApiCategoryModel  findByPK(BiApiCategoryModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiApiCategoryModel>  queryByCond(BiApiCategoryModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiApiCategoryModel>  queryByPage(BiApiCategoryModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiApiCategoryModel> list = mDao.queryByPage(model);
		PageBean<BiApiCategoryModel> page = new PageBean<BiApiCategoryModel>(list);
 		return page;
 	}

	public int insertSingle(BiApiCategoryModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}