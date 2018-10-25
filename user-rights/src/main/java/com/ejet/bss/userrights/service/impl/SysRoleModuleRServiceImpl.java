package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.bss.userrights.vo.SysRoleModuleRVO;
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
import com.ejet.bss.userrights.model.SysRoleModuleRModel;
import com.ejet.bss.userrights.mapper.SysRoleModuleRDao;
import com.ejet.bss.userrights.service.ISysRoleModuleRService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleModuleRService")
public class SysRoleModuleRServiceImpl implements ISysRoleModuleRService { 


	private final Logger log = LoggerFactory.getLogger(SysRoleModuleRServiceImpl.class);

	@Autowired
	private SysRoleModuleRDao mDao;

	@Override
	public void insertAutoKey(SysRoleModuleRModel model) throws CoBusinessException {
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleModuleRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleModuleRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysRoleModuleRModel  findByPK(SysRoleModuleRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleModuleRModel>  queryByCond(SysRoleModuleRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleModuleRModel>  queryByPage(SysRoleModuleRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleModuleRModel> list = mDao.queryByPage(model);
		PageBean<SysRoleModuleRModel> page = new PageBean<SysRoleModuleRModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleModuleRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}


    /**
     * 查询角色组(多个角色) 对应模块权限
     */
    public List<SysModuleModel> listRolesModules(List<SysRoleModel> list) throws CoBusinessException {
        //剔除掉重复记录
        return mDao.listRolesModules(list);
    }

    /**
     * 设置角色对应模块权限(单角色，多模块权限)
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
    public Integer saveRoleModules(List<SysRoleModuleRVO> list) throws CoBusinessException {
        Integer num = 0;
        SysRoleModuleRModel del = new SysRoleModuleRModel();
        if(list==null || list.size()==0) {
            throw new CoBusinessException(ExceptionCode.RIGHTS_ROLE_NO_SELECTED);
        }
        //先删除角色所有权限，然后再插入权限
        del.setRoleId(list.get(0).getRoleId());
        mDao.delete(del);
        // @ TODO 后续可以改进为批量插入，
        for(SysRoleModuleRModel model : list) {
            insertSingle(model);
        }
        return num;
    }

}