package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userrights.vo.SysRoleVO;
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
import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.bss.userrights.mapper.SysRoleDao;
import com.ejet.bss.userrights.service.ISysRoleService;
import sun.reflect.annotation.ExceptionProxy;

@Service("sysRoleService")
public class SysRoleServiceImpl implements ISysRoleService { 

	private final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);

	@Autowired
	private SysRoleDao mDao;

	@Override
	public void insertAutoKey(SysRoleModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleModel model) throws CoBusinessException {
        if(model.getId()==null && model.getRoleId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		mDao.delete(model);
 	}

	public SysRoleModel findByPK(SysRoleModel model) throws CoBusinessException {
        if(model.getId()==null && model.getRoleId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleModel>  queryByCond(SysRoleModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleModel> queryByPage(SysRoleModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleModel> list = mDao.queryByPage(model);
		PageBean<SysRoleModel> page = new PageBean<SysRoleModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleModel model) throws CoBusinessException {
        if(model==null || model.getRoleTypeId()==null) {
            throw new CoBusinessException(ExceptionCode.RIGHTS_ROLE_TYPE_NO_SELECTED);
        }
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		model.setRoleId(maxId);
 		model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}

    /**
     * 查询角色列表
     * @param model
     * @return
     * @throws CoBusinessException
     */
    public List<SysRoleVO> listRoles(SysRoleModel model) throws CoBusinessException {
        return mDao.listRoles(model);
    }


}