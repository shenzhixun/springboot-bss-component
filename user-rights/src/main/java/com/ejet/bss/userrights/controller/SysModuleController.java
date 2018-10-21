package com.ejet.bss.userrights.controller;

import com.ejet.bss.userrights.vo.SysModuleVO;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.tree.CoZtreeVO;
import com.ejet.comm.utils.tree.TreeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.TypeReference;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ejet.comm.Result;
import com.ejet.comm.Param;
import com.ejet.comm.PageBean;
import com.ejet.comm.base.CoBaseController;
import java.util.List;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;
import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.service.impl.SysModuleServiceImpl;
@RestController
@RequestMapping(value="/sys-module")
public class SysModuleController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(SysModuleController.class);
	@Autowired
	private SysModuleServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)SysModuleModel model) {
		Result rs = new Result();
		try {
			List<SysModuleModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)SysModuleModel model) {
		Result rs = new Result();
		try{
			mService.delete(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/add")
	public Result add(@RequestBody(required=true)SysModuleModel model) {
		Result rs = new Result();
		try{
			mService.insertSingle(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/update")
	public Result update(@RequestBody(required=true)SysModuleModel model) {
		Result rs = new Result();
		try{
			mService.update(model);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/query-by-page")
	public Result queryByPage(@RequestBody(required=true)Param param, BindingResult bindResult) {
		Result rs = new Result();
		try{
			checkBindResult(bindResult);
			SysModuleModel model = toBean(param, new TypeReference<SysModuleModel>(){});
			PageBean<SysModuleModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
			rs = new Result(pageBean.getPage(), pageBean.getResult());
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}catch (Exception e) {
			log.error("", e);
			rs = new Result(SYS_ERROR, e);
		}
		return rs;
	}


    /**
     * 获取菜单(树状)
     */
    @RequestMapping(value="/get_module_ztree")
    @ResponseBody
    public Result getModuleZtree(@RequestBody(required=false)Param<SysModuleVO> param, BindingResult bindResult) {
        Result rs = new Result();
        try {
            checkBindResult(bindResult);
            SysModuleModel model = param.getData();
            List<CoZtreeVO> result = mService.getModuleZtree(model, false);
            rs = new Result(result);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }

    /**
     * 获得模块树（采用树状接口）
     */
    @RequestMapping(value="/get_module_tree")
    @ResponseBody
    public Result getModuleTree(@RequestBody(required=false)Param<SysModuleVO> param, BindingResult bindResult) {
        Result rs = new Result();
        try {
            checkBindResult(bindResult);
            SysModuleVO model = toBean(param==null? new Param<SysModuleVO>() : param, new TypeReference<SysModuleVO>(){});
            List<TreeVO<SysModuleModel>> result = mService.getModuleTree(model);
            rs = new Result(result);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }


}