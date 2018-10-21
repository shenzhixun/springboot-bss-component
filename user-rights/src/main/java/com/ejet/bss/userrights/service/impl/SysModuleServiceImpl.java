package com.ejet.bss.userrights.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userrights.comm.ModuleBase;
import com.ejet.bss.userrights.service.comm.SysCoreCacheServiceImpl;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.comm.utils.tree.CoZtreeVO;
import com.ejet.comm.utils.tree.TreeVO;
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
import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.mapper.SysModuleDao;
import com.ejet.bss.userrights.service.ISysModuleService;
@Service("sysModuleService")
public class SysModuleServiceImpl extends ModuleBase implements ISysModuleService {
	private final Logger log = LoggerFactory.getLogger(SysModuleServiceImpl.class);
	@Autowired
	private SysModuleDao mDao;
    @Autowired
    private SysCoreCacheServiceImpl coreCacheService;

	@Override
	public void insertAutoKey(SysModuleModel model) throws CoBusinessException {
        model.setModifyTime(TimeUtils.getCurrentTimeInString());
        model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(SysModuleModel model) throws CoBusinessException { 
 		if(model.getId()==null && model.getModuleId()==null) {
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(SysModuleModel model) throws CoBusinessException {
        if(model.getId()==null && model.getModuleId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		mDao.delete(model);
 	}  

	public SysModuleModel findByPK(SysModuleModel model) throws CoBusinessException {
        if(model.getId()==null && model.getModuleId()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
 		return mDao.findByPK(model);
 	}

	@Override
	public List<SysModuleModel> queryByCond(SysModuleModel model) throws CoBusinessException {
 		return mDao.queryByCond(model);
 	}

	public PageBean<SysModuleModel>  queryByPage(SysModuleModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<SysModuleModel> list = mDao.queryByPage(model);
		PageBean<SysModuleModel> page = new PageBean<SysModuleModel>(list);
 		return page;
 	}

	public int insertSingle(SysModuleModel model) throws CoBusinessException { 
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
     * 新增模块
     * @param model
     * @throws CoBusinessException
     */
	public void save(SysModuleModel model) throws CoBusinessException {
        if(model.getModuleId()==null || model.getModuleNameEn()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }
	    // id 和 模块英文名字不允许重复
        SysModuleModel queryModule=new SysModuleModel();
        queryModule.setModuleId(model.getModuleId());
        queryModule.setModuleNameEn(model.getModuleNameEn());
        SysModuleModel PKResult = mDao.findByPK(queryModule);
        if(PKResult!=null) {
            throw new CoBusinessException("模块Id已存在,请修改后重试!");
        }

        queryModule.setModuleId(null);
        queryModule.setModuleNameEn(model.getModuleNameEn());
        PKResult = mDao.findByPK(queryModule);
        if(PKResult!=null) {
            throw new CoBusinessException("模块英文名已存在,请修改后重试!");
        }
        if(!StringUtils.isNull(model.getModulePid())) {
            //根据父模块id查询层级
            queryModule.setModuleNameEn(null);
            queryModule.setModuleId(model.getModulePid());
            SysModuleModel sysModuleModel = mDao.findByPK(queryModule);
            if(sysModuleModel!=null) {
                model.setModuleLevel(sysModuleModel.getModuleLevel()+1);
            }
            insertAutoKey(model);
        } else {
            //新增根节点
            model.setModulePid(0);
            model.setModuleLevel(1);
            mDao.insertAutoKey(model);
        }
 	}

    /**
     * 返回ztree菜单,数组结构（ztree中不能包含url，所以需要过滤掉，同时转换与ztree组件中字段对应）
     * @param model
     * @param hasURL
     * @return
     * @throws CoBusinessException
     */
    public List<CoZtreeVO> getModuleZtree(SysModuleModel model, boolean hasURL) throws CoBusinessException {
        log.info("getModuleZTree 数组方式......" + hasURL);
        List<SysModuleModel> lists = coreCacheService.getModuleAll(model);
        List<CoZtreeVO> allNode = transModuleZtree(lists, hasURL);
        return allNode;
    }


    /**
     * 返回带层级结构菜单
     */
    public List<TreeVO<SysModuleModel>> getModuleTree(SysModuleModel model) throws CoBusinessException {
        log.info("getModuleTrees 树状结构......");
        List<SysModuleModel> lists = coreCacheService.getModuleAll(model);
        List<TreeVO<SysModuleModel>> allNode = toModuleTreeVO(lists);
        return allNode;
    }



}