package com.ejet.bss.userrights.controller;

import com.ejet.bss.userrights.model.SysModuleModel;
import com.ejet.bss.userrights.model.SysRoleModel;
import com.ejet.bss.userrights.vo.SysRoleModuleRVO;
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
import com.ejet.bss.userrights.model.SysRoleModuleRModel;
import com.ejet.bss.userrights.service.impl.SysRoleModuleRServiceImpl;


/**
 *
 *  角色模块接口
 *
 * 查询角色对应模块功能权限(多个角色)：  {@link #getRoleModules(Param, BindingResult)}
 *
 *
 * @author ShenYijie
 *
 */
@RestController
@RequestMapping(value="/sys-role-module-r")
public class SysRoleModuleRController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(SysRoleModuleRController.class);
	@Autowired
	private SysRoleModuleRServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)SysRoleModuleRModel model) {
		Result rs = new Result();
		try {
			List<SysRoleModuleRModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)SysRoleModuleRModel model) {
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
	public Result add(@RequestBody(required=true)SysRoleModuleRModel model) {
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
	public Result update(@RequestBody(required=true)SysRoleModuleRModel model) {
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
			SysRoleModuleRModel model = toBean(param, new TypeReference<SysRoleModuleRModel>(){});
			PageBean<SysRoleModuleRModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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
     * 查询角色对应模块功能权限(多个角色)
     */
    @ResponseBody
    @RequestMapping(value="/get-role-modules")
    public Result getRoleModules(@RequestBody(required=true)Param<List<SysRoleModel>> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            List<SysRoleModel> model = param.getData();
            List<SysModuleModel> page = mService.listRolesModules(model);
            rs = new Result(page);
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
     * 设置 角色对应功能模块权限
     */
    @ResponseBody
    @RequestMapping(value="/set-role-modules")
    public Result setRoleModules(@RequestBody(required=true)Param<List<SysRoleModuleRVO>> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            mService.saveRoleModules(param.getData());
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }



}