package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userrights.service.comm.SysCoreCacheServiceImpl;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.global.CoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.bss.userrights.mapper.SysSyslevelDao;
import com.ejet.bss.userrights.service.ISysSyslevelService;
@Service("sysSyslevelService")
public class SysSyslevelServiceImpl implements ISysSyslevelService { 

	private final Logger log = LoggerFactory.getLogger(SysSyslevelServiceImpl.class);
    @Autowired
    private SysCoreCacheServiceImpl coreCacheService;

	@Autowired
	private SysSyslevelDao mDao;

	@Override
	public void insertAutoKey(SysSyslevelModel model) throws CoBusinessException {
        model.setModifyTime(TimeUtils.getCurrentTimeInString());
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysSyslevelModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysSyslevelModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysSyslevelModel  findByPK(SysSyslevelModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysSyslevelModel>  queryByCond(SysSyslevelModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysSyslevelModel>  queryByPage(SysSyslevelModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysSyslevelModel> list = mDao.queryByPage(model);
		PageBean<SysSyslevelModel> page = new PageBean<SysSyslevelModel>(list);
 		return page;
 	}

	public int insertSingle(SysSyslevelModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);

        model.setModifyTime(TimeUtils.getCurrentTimeInString());
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}

    /**
     * 获取所有数据权限体系
     */
    public List<SysSyslevelModel> getSyslevelAll(SysSyslevelModel model) throws CoBusinessException {
        log.info("getSyslevelAll......");
        List<SysSyslevelModel> list = coreCacheService.getSyslevelAll(model);
        return list;
    }


}