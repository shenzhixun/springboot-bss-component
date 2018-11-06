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
import com.ejet.bss.userflow.model.BssFlowApproveApplyModel;
import com.ejet.bss.userflow.mapper.BssFlowApproveApplyDao;
import com.ejet.bss.userflow.service.IBssFlowApproveApplyService;
@Service("bssFlowApproveApplyService")
public class BssFlowApproveApplyServiceImpl implements IBssFlowApproveApplyService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowApproveApplyServiceImpl.class);

	@Autowired
	private BssFlowApproveApplyDao mDao;

	@Override
	public int insertAutoKey(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowApproveApplyModel  findByPK(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowApproveApplyModel>  queryByCond(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowApproveApplyModel>  queryByPage(BssFlowApproveApplyModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowApproveApplyModel> list = mDao.queryByPage(model);
		PageBean<BssFlowApproveApplyModel> page = new PageBean<BssFlowApproveApplyModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowApproveApplyModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}