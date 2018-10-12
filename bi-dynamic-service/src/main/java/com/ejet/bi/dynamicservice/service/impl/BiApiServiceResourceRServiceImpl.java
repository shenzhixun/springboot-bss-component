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
import com.ejet.bi.dynamicservice.model.BiApiServiceResourceRModel;
import com.ejet.bi.dynamicservice.mapper.BiApiServiceResourceRDao;
import com.ejet.bi.dynamicservice.service.IBiApiServiceResourceRService;
@Service("biApiServiceResourceRService")
public class BiApiServiceResourceRServiceImpl implements IBiApiServiceResourceRService { 


	private final Logger log = LoggerFactory.getLogger(BiApiServiceResourceRServiceImpl.class);

	@Autowired
	private BiApiServiceResourceRDao mDao;

	@Override
	public void insertAutoKey(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiApiServiceResourceRModel  findByPK(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiApiServiceResourceRModel>  queryByCond(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiApiServiceResourceRModel>  queryByPage(BiApiServiceResourceRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiApiServiceResourceRModel> list = mDao.queryByPage(model);
		PageBean<BiApiServiceResourceRModel> page = new PageBean<BiApiServiceResourceRModel>(list);
 		return page;
 	}

	public int insertSingle(BiApiServiceResourceRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}