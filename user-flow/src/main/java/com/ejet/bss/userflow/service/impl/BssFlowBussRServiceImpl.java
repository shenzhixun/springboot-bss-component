package com.ejet.bss.userflow.service.impl;

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
import com.ejet.bss.userflow.model.BssFlowBussRModel;
import com.ejet.bss.userflow.mapper.BssFlowBussRDao;
import com.ejet.bss.userflow.service.IBssFlowBussRService;
@Service("bssFlowBussRService")
public class BssFlowBussRServiceImpl implements IBssFlowBussRService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowBussRServiceImpl.class);

	@Autowired
	private BssFlowBussRDao mDao;

	@Override
	public void insertAutoKey(BssFlowBussRModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowBussRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowBussRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowBussRModel  findByPK(BssFlowBussRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowBussRModel>  queryByCond(BssFlowBussRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowBussRModel>  queryByPage(BssFlowBussRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowBussRModel> list = mDao.queryByPage(model);
		PageBean<BssFlowBussRModel> page = new PageBean<BssFlowBussRModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowBussRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}