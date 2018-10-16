package com.ejet.bi.dynamicservice.service.impl;

import com.ejet.bi.dynamicservice.bo.BiApiBO;
import com.ejet.bi.dynamicservice.vo.BiApiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiServiceModel;
import com.ejet.bi.dynamicservice.mapper.BiApiServiceDao;
import com.ejet.bi.dynamicservice.service.IBiApiServiceService;
@Service("biApiServiceService")
public class BiApiServiceServiceImpl implements IBiApiServiceService { 

	private final Logger log = LoggerFactory.getLogger(BiApiServiceServiceImpl.class);

	@Autowired
	private BiApiServiceDao mDao;

	@Override
	public void insertAutoKey(BiApiServiceModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BiApiServiceModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BiApiServiceModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BiApiServiceModel  findByPK(BiApiServiceModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BiApiServiceModel>  queryByCond(BiApiServiceModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BiApiServiceModel>  queryByPage(BiApiServiceModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BiApiServiceModel> list = mDao.queryByPage(model);
		PageBean<BiApiServiceModel> page = new PageBean<BiApiServiceModel>(list);
 		return page;
 	}

	public int insertSingle(BiApiServiceModel model) throws CoBusinessException { 
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
    public Map<String, BiApiBO> queryApi(BiApiVO model) throws CoBusinessException {
        Map<String, BiApiBO> map = new HashMap<>();
        List<BiApiVO> result = mDao.queryApi(model);
        if(result!=null) {
            for (BiApiVO item : result) {
                String key = item.getPath();
                BiApiBO bo = bo = new BiApiBO();
                if(map.containsKey(key)) {
                    bo = map.get(key);
                }
                bo.setUrl(key);
                bo.getList().add(item);
                map.put(key, bo);
            }
        }
        return map;
    }


}