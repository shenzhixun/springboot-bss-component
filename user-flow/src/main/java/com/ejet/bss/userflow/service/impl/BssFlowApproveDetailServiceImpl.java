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
import com.ejet.bss.userflow.model.BssFlowApproveDetailModel;
import com.ejet.bss.userflow.mapper.BssFlowApproveDetailDao;
import com.ejet.bss.userflow.service.IBssFlowApproveDetailService;
@Service("bssFlowApproveDetailService")
public class BssFlowApproveDetailServiceImpl implements IBssFlowApproveDetailService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowApproveDetailServiceImpl.class);

	@Autowired
	private BssFlowApproveDetailDao mDao;

	@Override
	public int insertAutoKey(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowApproveDetailModel  findByPK(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowApproveDetailModel>  queryByCond(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowApproveDetailModel>  queryByPage(BssFlowApproveDetailModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowApproveDetailModel> list = mDao.queryByPage(model);
		PageBean<BssFlowApproveDetailModel> page = new PageBean<BssFlowApproveDetailModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowApproveDetailModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}