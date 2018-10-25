package com.ejet.bss.userrights.controller;

import com.ejet.bss.userrights.model.SysSyslevelModel;
import com.ejet.comm.exception.CoBusinessException;
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
import com.ejet.bss.userrights.model.SysRoleSyslevelRModel;
import com.ejet.bss.userrights.service.impl.SysRoleSyslevelRServiceImpl;
@RestController
@RequestMapping(value="/sys-role-syslevel-r")
public class SysRoleSyslevelRController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(SysRoleSyslevelRController.class);
	@Autowired
	private SysRoleSyslevelRServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)SysRoleSyslevelRModel model) {
		Result rs = new Result();
		try {
			List<SysRoleSyslevelRModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)SysRoleSyslevelRModel model) {
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
	public Result add(@RequestBody(required=true)SysRoleSyslevelRModel model) {
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
	public Result update(@RequestBody(required=true)SysRoleSyslevelRModel model) {
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
			SysRoleSyslevelRModel model = toBean(param, new TypeReference<SysRoleSyslevelRModel>(){});
			PageBean<SysRoleSyslevelRModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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
     * 查询角色对应数据权限
     */
    @ResponseBody
    @RequestMapping(value="/get-role-syslevels")
    public Result getRoleSyslevels(@RequestBody(required=true)Param<List<SysRoleSyslevelRModel>> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            List<SysRoleSyslevelRModel> model = param.getData();
            List<SysSyslevelModel> page = mService.listRolesSyslevels(model);
            rs = new Result(page);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }


    /**
     * 设置 角色对应数据权限
     */
    @ResponseBody
    @RequestMapping(value="/set-role-syslevels")
    public Result setRoleSyslevels(@RequestBody(required=true)Param<List<SysRoleSyslevelRModel>> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            List<SysRoleSyslevelRModel> list = param.getData();
            mService.saveRoleSyslevels(list);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }

}