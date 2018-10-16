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
import com.ejet.bss.userflow.model.BssFlowApproveModel;
import com.ejet.bss.userflow.mapper.BssFlowApproveDao;
import com.ejet.bss.userflow.service.IBssFlowApproveService;
@Service("bssFlowApproveService")
public class BssFlowApproveServiceImpl implements IBssFlowApproveService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowApproveServiceImpl.class);

	@Autowired
	private BssFlowApproveDao mDao;

	@Override
	public void insertAutoKey(BssFlowApproveModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowApproveModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowApproveModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowApproveModel  findByPK(BssFlowApproveModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowApproveModel>  queryByCond(BssFlowApproveModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowApproveModel>  queryByPage(BssFlowApproveModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowApproveModel> list = mDao.queryByPage(model);
		PageBean<BssFlowApproveModel> page = new PageBean<BssFlowApproveModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowApproveModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}