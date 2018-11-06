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
import com.ejet.bss.userflow.model.BssFlowApproveNoticeModel;
import com.ejet.bss.userflow.mapper.BssFlowApproveNoticeDao;
import com.ejet.bss.userflow.service.IBssFlowApproveNoticeService;
@Service("bssFlowApproveNoticeService")
public class BssFlowApproveNoticeServiceImpl implements IBssFlowApproveNoticeService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowApproveNoticeServiceImpl.class);

	@Autowired
	private BssFlowApproveNoticeDao mDao;

	@Override
	public int insertAutoKey(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowApproveNoticeModel  findByPK(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowApproveNoticeModel>  queryByCond(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowApproveNoticeModel>  queryByPage(BssFlowApproveNoticeModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowApproveNoticeModel> list = mDao.queryByPage(model);
		PageBean<BssFlowApproveNoticeModel> page = new PageBean<BssFlowApproveNoticeModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowApproveNoticeModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}