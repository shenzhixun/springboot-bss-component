package com.ejet.bss.userinfo.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userinfo.vo.SysAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.bss.userinfo.mapper.SysAccountDao;
import com.ejet.bss.userinfo.service.ISysAccountService;
@Service("sysAccountService")
public class SysAccountServiceImpl implements ISysAccountService { 


	private final Logger log = LoggerFactory.getLogger(SysAccountServiceImpl.class);

	@Autowired
	private SysAccountDao mDao;

	@Override
	public void insertAutoKey(SysAccountModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysAccountModel  findByPK(SysAccountModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountModel>  queryByCond(SysAccountModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountModel>  queryByPage(SysAccountModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountModel> list = mDao.queryByPage(model);
		PageBean<SysAccountModel> page = new PageBean<SysAccountModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


    public SysAccountVO login(SysAccountModel model) throws CoBusinessException {
        return mDao.login(model);
    }



}