package com.ejet.bss.userrights.service.impl;

import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.bss.userrights.vo.SysAccountSpecialVO;
import com.ejet.bss.userrights.vo.SysSyslevelVO;
import com.ejet.comm.utils.collect.ListUtils;
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
import com.ejet.bss.userrights.model.SysRoleSyslevelRModel;
import com.ejet.bss.userrights.mapper.SysRoleSyslevelRDao;
import com.ejet.bss.userrights.service.ISysRoleSyslevelRService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sysRoleSyslevelRService")
public class SysRoleSyslevelRServiceImpl implements ISysRoleSyslevelRService { 

	private final Logger log = LoggerFactory.getLogger(SysRoleSyslevelRServiceImpl.class);

	@Autowired
	private SysRoleSyslevelRDao mDao;

	@Override
	public int insertAutoKey(SysRoleSyslevelRModel model) throws CoBusinessException {
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public SysRoleSyslevelRModel  findByPK(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysRoleSyslevelRModel>  queryByCond(SysRoleSyslevelRModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysRoleSyslevelRModel>  queryByPage(SysRoleSyslevelRModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysRoleSyslevelRModel> list = mDao.queryByPage(model);
		PageBean<SysRoleSyslevelRModel> page = new PageBean<SysRoleSyslevelRModel>(list);
 		return page;
 	}

	public int insertSingle(SysRoleSyslevelRModel model) throws CoBusinessException {
        // Integer maxId = mDao.findMaxId(null);
        // maxId = maxId==null? 1 : maxId+1;
        // model.setId(maxId);
        //model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
        //mDao.insertSingle(model);
 		return insertAutoKey(model);
 	}


    /**
     * 查询角色数据权限（请求带体系类型）
     * @param list
     * @return
     * @throws CoBusinessException
     */
    public List<SysSyslevelModel> listRolesSyslevels(List<SysRoleSyslevelRModel> list) throws CoBusinessException {
        SysSyslevelVO query = new SysSyslevelVO();
        for(SysRoleSyslevelRModel item : list) {
            SysSyslevelModel level = new SysSyslevelModel();
            level.setSyslevelType(item.getSyslevelType());
            query.getSyslevels().add(level);//设置体系类型

            SysAccountRoleRModel role = new SysAccountRoleRModel();
            role.setRoleId(item.getRoleId());
            query.getAccountRoles().add(role); //设置角色ID
        }
        return mDao.listRolesSyslevels(query);
    }


    /**
     * 查询角色组数据权限(所有体系)
     */
    public List<SysSyslevelModel> listRolesSyslevelsAll(List<SysRoleModel> list) throws CoBusinessException {
        SysSyslevelVO query = new SysSyslevelVO();
        query.setSyslevels(null); //不作为查询条件，获取所有体系
        if(ListUtils.isEmpty(list)){
            return null;
        }else{
            for(SysRoleModel item : list) {
                SysAccountRoleRModel role = new SysAccountRoleRModel();
                role.setRoleId(item.getRoleId());
                query.getAccountRoles().add(role); //设置角色ID
            }
            return mDao.listRolesSyslevels(query);
        }
    }

    /**
     * 查询特殊角色类型对应数据
     *
     * @param vo
     * @return
     * @throws CoBusinessException
     */
    public List<SysSyslevelModel> listRoleSyslevelsSpecial(SysAccountSpecialVO vo) throws CoBusinessException {
        return mDao.listRoleSyslevelsSpecial(vo);
    }


    /**
     *  保存角色对应数据权限
     *
     * @param list
     * @throws CoBusinessException
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout=36000, rollbackFor={Exception.class,CoBusinessException.class})
    public int saveRoleSyslevels(List<SysRoleSyslevelRModel> list) throws CoBusinessException {
        // TODO Auto-generated method stub
        int num = 0;
        if(list==null || list.size()==0) {
            throw new CoBusinessException(ExceptionCode.RIGHTS_ROLE_NO_SELECTED);
        }
        SysRoleSyslevelRModel del = new SysRoleSyslevelRModel();
        del.setRoleId(list.get(0).getRoleId());
        mDao.delete(del);

        // @ TODO 后续可以改进为批量插入，
        for(SysRoleSyslevelRModel model : list) {
            insertSingle(model);
        }
        return num;
    }


}