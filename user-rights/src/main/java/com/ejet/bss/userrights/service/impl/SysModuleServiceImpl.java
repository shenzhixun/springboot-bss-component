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
        List<SysModuleModel> resultList = queryChilds(model);
        if(resultList!=null && resultList.size()>0) {
            throw new CoBusinessException("模块下存在子模块，不允许删除,请删除子模块后再重试!");
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

	public PageBean<SysModuleModel> queryByPage(SysModuleModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
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
     * 查询模块下面子模块（非递归查询）
     *
     * @param model
     * @throws CoBusinessException
     */
 	public List<SysModuleModel> queryChilds(SysModuleModel model) throws CoBusinessException {
        //查询模块下是否有子模块
        SysModuleModel queryChildsModule=new SysModuleModel();
        queryChildsModule.setModulePid(model.getModuleId());
        List<SysModuleModel> resultList = queryByCond(queryChildsModule);
        return resultList;
    }

    /**
     * 所有模块英文名不允许重复
     * @param model
     * @throws CoBusinessException
     */
    public void checkNameEn(SysModuleModel model) throws CoBusinessException {
        //查询模块名字是否重复
        SysModuleModel queryChildsModule=new SysModuleModel();
        //queryChildsModule.setModulePid(model.getModulePid());
        queryChildsModule.setModuleNameEn(model.getModuleNameEn());
        List<SysModuleModel> resultList = mDao.queryByCond(queryChildsModule);
        if(resultList!=null && resultList.size()>0) {
            throw new CoBusinessException("模块英文名已存在,请修改后重试!");
        }
    }

    /**
     * 查询模块id是否重复
     */
    public void checkMoudleId(SysModuleModel model) throws CoBusinessException {
        SysModuleModel queryModule=new SysModuleModel();
        queryModule.setModuleId(model.getModuleId());
        SysModuleModel result = mDao.findByPK(queryModule);
        if(result!=null) {
            throw new CoBusinessException("模块Id已存在,请修改后重试!");
        }
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
        checkMoudleId(model);

        //检查英文名
        checkNameEn(model);

        if(!StringUtils.isNull(model.getModulePid())) {
            //根据父模块id查询层级
            SysModuleModel parentQuery=new SysModuleModel();
            parentQuery.setModuleId(model.getModulePid());
            SysModuleModel parentModel = mDao.findByPK(parentQuery);
            if(parentModel==null) {
                throw new CoBusinessException("上级模块不存在,请修改后重试!");
            }
            model.setModuleLevel(parentModel.getModuleLevel()+1);
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

    /**
     * 返回菜单（数组方式）
     */
    public List<SysModuleModel> getModuleAll(SysModuleModel model) throws CoBusinessException {
        log.info(" getModuleAll 数组结构......");
        List<SysModuleModel> list = coreCacheService.getModuleAll(model);
        return list;
    }



}