package com.ejet.bi.dynamicservice.service.impl;

import java.sql.SQLException;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.bi.dynamicservice.vo.BiResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceModel;
import com.ejet.bi.dynamicservice.mapper.BiResourceDao;
import com.ejet.bi.dynamicservice.service.IBiResourceService;
@Service("biResourceService")
public class BiResourceServiceImpl implements IBiResourceService { 


	private final Logger log = LoggerFactory.getLogger(BiResourceServiceImpl.class);

	@Autowired
	private BiResourceDao mDao;

	@Override
	public void insertAutoKey(BiResourceModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiResourceModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiResourceModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiResourceModel  findByPK(BiResourceModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiResourceModel>  queryByCond(BiResourceModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiResourceModel>  queryByPage(BiResourceModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiResourceModel> list = mDao.queryByPage(model);
		PageBean<BiResourceModel> page = new PageBean<BiResourceModel>(list);
 		return page;
 	}

	public int insertSingle(BiResourceModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


 	public List<BiResourceVO> queryResouceBatch(List<BiApiVO> list) throws CoBusinessException {
        List<BiResourceVO> result = null;

        return result;
    }




}