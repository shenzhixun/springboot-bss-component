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
import com.ejet.bi.dynamicservice.model.BiResourceParamModel;
import com.ejet.bi.dynamicservice.mapper.BiResourceParamDao;
import com.ejet.bi.dynamicservice.service.IBiResourceParamService;
@Service("biResourceParamService")
public class BiResourceParamServiceImpl implements IBiResourceParamService { 


	private final Logger log = LoggerFactory.getLogger(BiResourceParamServiceImpl.class);

	@Autowired
	private BiResourceParamDao mDao;

	@Override
	public void insertAutoKey(BiResourceParamModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiResourceParamModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiResourceParamModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiResourceParamModel  findByPK(BiResourceParamModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiResourceParamModel>  queryByCond(BiResourceParamModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiResourceParamModel>  queryByPage(BiResourceParamModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiResourceParamModel> list = mDao.queryByPage(model);
		PageBean<BiResourceParamModel> page = new PageBean<BiResourceParamModel>(list);
 		return page;
 	}

	public int insertSingle(BiResourceParamModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}