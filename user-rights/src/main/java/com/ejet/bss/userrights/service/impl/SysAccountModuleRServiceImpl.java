package com.ejet.bss.userrights.service.impl;

import com.ejet.bss.userrights.model.SysModuleModel;
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
import com.ejet.bss.userrights.model.SysAccountModuleRModel;
import com.ejet.bss.userrights.mapper.SysAccountModuleRDao;
import com.ejet.bss.userrights.service.ISysAccountModuleRService;
@Service("sysAccountModuleRService")
public class SysAccountModuleRServiceImpl implements ISysAccountModuleRService { 
	private final Logger log = LoggerFactory.getLogger(SysAccountModuleRServiceImpl.class);

	@Autowired
	private SysAccountModuleRDao mDao;

	@Override
	public void insertAutoKey(SysAccountModuleRModel model) throws CoBusinessException {
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountModuleRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountModuleRModel model) throws CoBusinessException {

 		mDao.delete(model);
 	}  

	public SysAccountModuleRModel findByPK(SysAccountModuleRModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountModuleRModel> queryByCond(SysAccountModuleRModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountModuleRModel> queryByPage(SysAccountModuleRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountModuleRModel> list = mDao.queryByPage(model);
		PageBean<SysAccountModuleRModel> page = new PageBean<SysAccountModuleRModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountModuleRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}


    /**
     * 查询账号对应模块功能权限
     */
    public List<SysModuleModel> listAccountModules(SysAccountModuleRModel model) throws CoBusinessException {
        return mDao.listAccountModules(model);
    }






}