package com.ejet.bi.dynamicservice.service.impl;

import java.sql.SQLException;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiDefineModel;
import com.ejet.bi.dynamicservice.mapper.BiApiDefineDao;
import com.ejet.bi.dynamicservice.service.IBiApiDefineService;
@Service("biApiDefineService")
public class BiApiDefineServiceImpl implements IBiApiDefineService { 

	private final Logger log = LoggerFactory.getLogger(BiApiDefineServiceImpl.class);

	@Autowired
	private BiApiDefineDao mDao;

	@Override
	public void insertAutoKey(BiApiDefineModel model) throws CoBusinessException { 
 		 mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiApiDefineModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		 mDao.update(model);
 	}  

	@Override
	public void delete(BiApiDefineModel model) throws CoBusinessException { 
 		 mDao.delete(model);
 	}  

	public BiApiDefineModel  findByPK(BiApiDefineModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}  

	@Override
	public List<BiApiDefineModel>  queryByCond(BiApiDefineModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}  
	public PageBean<BiApiDefineModel>  queryByPage(BiApiDefineModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<BiApiDefineModel> list = mDao.queryByPage(model);
		PageBean<BiApiDefineModel> page = new PageBean<BiApiDefineModel>(list);
 		return page;
 	}

	public int insertSingle(BiApiDefineModel model) throws CoBusinessException {
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}

    /**
     * 查询定义接口信息
     *
     * @param model
     * @return
     * @throws CoBusinessException
     */
    public List<BiApiVO> queryApi(BiApiVO model) throws CoBusinessException {
        return mDao.queryApi(model);
    }


}