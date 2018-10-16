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
import com.ejet.bss.userflow.model.BssFlowNodeModel;
import com.ejet.bss.userflow.mapper.BssFlowNodeDao;
import com.ejet.bss.userflow.service.IBssFlowNodeService;
@Service("bssFlowNodeService")
public class BssFlowNodeServiceImpl implements IBssFlowNodeService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowNodeServiceImpl.class);

	@Autowired
	private BssFlowNodeDao mDao;

	@Override
	public void insertAutoKey(BssFlowNodeModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowNodeModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowNodeModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowNodeModel  findByPK(BssFlowNodeModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowNodeModel>  queryByCond(BssFlowNodeModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowNodeModel>  queryByPage(BssFlowNodeModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowNodeModel> list = mDao.queryByPage(model);
		PageBean<BssFlowNodeModel> page = new PageBean<BssFlowNodeModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowNodeModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


}