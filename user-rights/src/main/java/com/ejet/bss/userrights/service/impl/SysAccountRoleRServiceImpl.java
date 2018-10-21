package com.ejet.bss.userrights.service.impl;

import com.ejet.bss.userrights.mapper.SysRoleDao;
import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.bss.userrights.vo.SysAccountRoleRVO;
import com.ejet.global.CoConstant;
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
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.mapper.SysAccountRoleRDao;
import com.ejet.bss.userrights.service.ISysAccountRoleRService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sysAccountRoleRService")
public class SysAccountRoleRServiceImpl implements ISysAccountRoleRService { 

	private final Logger log = LoggerFactory.getLogger(SysAccountRoleRServiceImpl.class);

	@Autowired
	private SysAccountRoleRDao mDao;
    @Autowired
    private SysRoleDao roleDao;

	@Override
	public void insertAutoKey(SysAccountRoleRModel model) throws CoBusinessException {
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysAccountRoleRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysAccountRoleRModel model) throws CoBusinessException {
        if(model.getId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		mDao.delete(model);
 	}  

	public SysAccountRoleRModel findByPK(SysAccountRoleRModel model) throws CoBusinessException {
        if(model.getId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysAccountRoleRModel>  queryByCond(SysAccountRoleRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysAccountRoleRModel>  queryByPage(SysAccountRoleRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysAccountRoleRModel> list = mDao.queryByPage(model);
		PageBean<SysAccountRoleRModel> page = new PageBean<SysAccountRoleRModel>(list);
 		return page;
 	}

	public int insertSingle(SysAccountRoleRModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);

        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}


    /**
     * 通过事务处理
     *
     * 用户对应角色关系设置
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
    public int save(List<SysAccountRoleRVO> list) throws CoBusinessException {
        int num = 0;
        if(list==null || list.size()==0) {
            throw new CoBusinessException(ExceptionCode.RIGHTS_USER_NO_ROLES);
        }
        Map<String, String> delmap = new HashMap<>();
        // @ TODO 后续可以改进为批量插入，
        for(SysAccountRoleRModel model : list) {
            //查询角色对应是否存在
            SysRoleModel queryRole = new SysRoleModel();
            queryRole.setRoleId(model.getRoleId());
            if(roleDao.queryByCond(queryRole)==null) {
                throw new CoBusinessException(ExceptionCode.RIGHTS_ROLES_NOT_EXIST);
            }
            if(delmap.get(model.getAccountUuid())==null) {
                SysAccountRoleRModel del = new SysAccountRoleRModel();
                del.setAccountUuid(model.getAccountUuid());
                mDao.delete(del);
                delmap.put(model.getAccountUuid(), "hasDelete");
            }
            mDao.insertAutoKey(model);
        }
        return num;
    }


    /**
     * 获取用户对应角色信息(不分页)
     */
    public List<SysAccountRoleRVO> listAccountRoles(SysAccountRoleRVO obj) throws CoBusinessException {
        List<SysAccountRoleRVO> list = mDao.listAccountRoles(obj);
        return list;
    }






}