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
import com.ejet.bi.dynamicservice.model.BiResourceCategoryModel;
import com.ejet.bi.dynamicservice.mapper.BiResourceCategoryDao;
import com.ejet.bi.dynamicservice.service.IBiResourceCategoryService;
@Service("biResourceCategoryService")
public class BiResourceCategoryServiceImpl implements IBiResourceCategoryService { 


	private final Logger log = LoggerFactory.getLogger(BiResourceCategoryServiceImpl.class);

	@Autowired
	private BiResourceCategoryDao mDao;

	@Override
	public void insertAutoKey(BiResourceCategoryModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiResourceCategoryModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiResourceCategoryModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiResourceCategoryModel  findByPK(BiResourceCategoryModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiResourceCategoryModel>  queryByCond(BiResourceCategoryModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiResourceCategoryModel>  queryByPage(BiResourceCategoryModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiResourceCategoryModel> list = mDao.queryByPage(model);
		PageBean<BiResourceCategoryModel> page = new PageBean<BiResourceCategoryModel>(list);
 		return page;
 	}

	public int insertSingle(BiResourceCategoryModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}