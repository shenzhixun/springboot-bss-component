package com.ejet.bss.userrights.controller;

import com.ejet.bss.userrights.vo.SysAccountRoleRVO;
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
import com.ejet.bss.userrights.model.SysAccountRoleRModel;
import com.ejet.bss.userrights.service.impl.SysAccountRoleRServiceImpl;
@RestController
@RequestMapping(value="/sys-account-role-r")
public class SysAccountRoleRController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(SysAccountRoleRController.class);
	@Autowired
	private SysAccountRoleRServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)SysAccountRoleRModel model) {
		Result rs = new Result();
		try {
			List<SysAccountRoleRModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)SysAccountRoleRModel model) {
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
	public Result add(@RequestBody(required=true)SysAccountRoleRModel model) {
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
	public Result update(@RequestBody(required=true)SysAccountRoleRModel model) {
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
			SysAccountRoleRModel model = toBean(param, new TypeReference<SysAccountRoleRModel>(){});
			PageBean<SysAccountRoleRModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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
     * 设置账号角色组
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/set_account_roles")
    public Result setAccountRoles(@RequestBody(required = true) Param<List<SysAccountRoleRVO>> param) {
        Result rs = new Result();
        try {
            mService.save(param.getData());
        } catch (CoBusinessException e) {
            rs = new Result(e);
            log.error("", e);
        }
        return rs;
    }

    /**
     * 查询账号角色关联
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get_account_roles")
    public Result getAccountRoles(@RequestBody(required = true)SysAccountRoleRVO model) {
        Result rs = new Result();
        try {
            List<SysAccountRoleRVO> list = mService.listAccountRoles(model);
            rs = new Result(list);
        } catch (CoBusinessException e) {
            rs = new Result(e);
            log.error("", e);
        }
        return rs;
    }


}