package com.ejet.bss.userrights.service.impl;


import com.ejet.bss.userrights.comm.ConstantUserRights;
import com.ejet.bss.userrights.model.SysSyslevelModel;
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
import com.ejet.bss.userrights.model.SysOrgzModel;
import com.ejet.bss.userrights.mapper.SysOrgzDao;
import com.ejet.bss.userrights.service.ISysOrgzService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sysOrgzService")
public class SysOrgzServiceImpl implements ISysOrgzService { 

	private final Logger log = LoggerFactory.getLogger(SysOrgzServiceImpl.class);

	@Autowired
	private SysOrgzDao mDao;

	@Autowired
    private SysSyslevelServiceImpl sysSyslevelService;


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,
            rollbackFor = {Exception.class, CoBusinessException.class})
	@Override
	public int insertAutoKey(SysOrgzModel model) throws CoBusinessException {
        model.setModifyTime(TimeUtils.getCurrentTimeInString());
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		return mDao.insertAutoKey(model);
 	}


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,
            rollbackFor = {Exception.class, CoBusinessException.class})
	@Override
	public void update(SysOrgzModel model) throws CoBusinessException { 
 		if(model.getId()==null || model.getOrgzId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}

        SysOrgzModel queryParent = new SysOrgzModel();
        queryParent.setOrgzId(model.getOrgzPid());
        SysOrgzModel parentOrgz = findByPK(queryParent);
        if(parentOrgz==null) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "上级组织不存在!");
        }

        //新增组织结构，先需要新增到
        model.setOrgzLevel(parentOrgz.getOrgzLevel()+1);

        // 查询组织是否重复名称
        SysOrgzModel existQueryOrgz = new SysOrgzModel();
        existQueryOrgz.setOrgzPid(model.getOrgzPid());
        existQueryOrgz.setOrgzName(model.getOrgzName());
        existQueryOrgz.setOrgzLevel(model.getOrgzLevel());

        List<SysOrgzModel> existOrgz = queryByCond(existQueryOrgz);
        if(existOrgz!=null && existOrgz.size()>0) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "上级组织[" + parentOrgz.getOrgzName() + "]，存在名称重复!");
        }

 		mDao.update(model);

        //插入到权限表中
        SysSyslevelModel syslevel = new SysSyslevelModel();
        syslevel.setId(model.getId());
        syslevel.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_ORGZ);
        syslevel.setSyslevelId(model.getOrgzId());
        syslevel.setSyslevelPid(model.getOrgzPid());
        syslevel.setLevels(model.getOrgzLevel());
        syslevel.setSyslevelName(model.getOrgzName());
        syslevel.setStatus(CoConstant.STATUS_NORMAL);
        sysSyslevelService.update(syslevel);
 	}


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,
            rollbackFor = {Exception.class, CoBusinessException.class})
	@Override
	public void delete(SysOrgzModel model) throws CoBusinessException {
        List<SysOrgzModel> resultList = queryChilds(model);
        if(resultList!=null && resultList.size()>0) {
            throw new CoBusinessException("组织下存在子节点，不允许删除,请删除子节点后再重试!");
        }
 		mDao.delete(model);

        SysSyslevelModel syslevel = new SysSyslevelModel();
        syslevel.setLevels(model.getOrgzId());
        sysSyslevelService.delete(syslevel);
 	}

	public SysOrgzModel findByPK(SysOrgzModel model) throws CoBusinessException {
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysOrgzModel> queryByCond(SysOrgzModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysOrgzModel> queryByPage(SysOrgzModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<SysOrgzModel> list = mDao.queryByPage(model);
		PageBean<SysOrgzModel> page = new PageBean<SysOrgzModel>(list);
 		return page;
 	}


    /**
     * 查询子节点（非递归查询）
     */
    public List<SysOrgzModel> queryChilds(SysOrgzModel model) throws CoBusinessException {
        //查询子节点
        SysOrgzModel queryChilds = new SysOrgzModel();
        queryChilds.setOrgzPid(model.getOrgzId());
        List<SysOrgzModel> resultList = queryByCond(queryChilds);
        return resultList;
    }

    /**
     *  新增组织
     *
     * @param model
     * @return
     * @throws CoBusinessException
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,
            rollbackFor = {Exception.class, CoBusinessException.class})
	public int insertSingle(SysOrgzModel model) throws CoBusinessException {
	    if(model.getOrgzPid()==null || model.getOrgzName()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
        }

        SysOrgzModel queryParent = new SysOrgzModel();
        queryParent.setOrgzId(model.getOrgzPid());
        SysOrgzModel parentOrgz = findByPK(queryParent);
        if(parentOrgz==null) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "上级组织不存在!");
        }

        //新增组织结构，先需要新增到
        model.setOrgzLevel(parentOrgz.getOrgzLevel()+1);

        // 查询组织是否重复名称
        SysOrgzModel existQueryOrgz = new SysOrgzModel();
        existQueryOrgz.setOrgzPid(model.getOrgzPid());
        existQueryOrgz.setOrgzName(model.getOrgzName());
        existQueryOrgz.setOrgzLevel(model.getOrgzLevel());

        List<SysOrgzModel> existOrgz = queryByCond(existQueryOrgz);
        if(existOrgz!=null && existOrgz.size()>0) {
            throw new CoBusinessException(ExceptionCode.SYS_ERROR, "上级组织[" + parentOrgz.getOrgzName() + "]，存在名称重复!");
        }

        Integer maxOrgzId = mDao.findMaxId(null);
        maxOrgzId = maxOrgzId==null? 1 : maxOrgzId+1;

        int id = insertAutoKey(model);

        //插入到权限表中
        SysSyslevelModel syslevel = new SysSyslevelModel();
        syslevel.setId(id);
        syslevel.setSyslevelType(ConstantUserRights.SYSLEVEL_TYPE_ORGZ);
        syslevel.setSyslevelId(maxOrgzId);
        syslevel.setSyslevelPid(model.getOrgzPid());
        syslevel.setLevels(model.getOrgzLevel());
        syslevel.setSyslevelName(model.getOrgzName());
        syslevel.setStatus(CoConstant.STATUS_NORMAL);
        sysSyslevelService.insertSingle(syslevel);
 		return maxOrgzId;
 	}




}