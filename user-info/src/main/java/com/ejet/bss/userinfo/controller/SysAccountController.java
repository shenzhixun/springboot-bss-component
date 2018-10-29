package com.ejet.bss.userinfo.controller;

import com.ejet.bss.userinfo.service.comm.LoginServiceImpl;
import com.ejet.bss.userinfo.vo.SysAccountUpdateVO;
import com.ejet.bss.userinfo.vo.SysAccountVO;
import com.ejet.comm.exception.CoBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ejet.comm.Result;
import com.ejet.comm.Param;
import com.ejet.comm.PageBean;
import com.ejet.comm.base.CoBaseController;
import java.util.List;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;
import com.ejet.bss.userinfo.model.SysAccountModel;
import com.ejet.bss.userinfo.service.impl.SysAccountServiceImpl;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/sys-account")
public class SysAccountController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(SysAccountController.class);
	@Autowired
	private SysAccountServiceImpl mService;

	@Autowired
	private LoginServiceImpl loginService;

	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)SysAccountModel model) {
		Result rs = new Result();
		try {
			List<SysAccountModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}

	@ResponseBody
	@RequestMapping(value="/find-by-pk")
	public Result findByPK(@RequestBody(required=true)SysAccountModel model) {
		Result rs = new Result();
		try {
            SysAccountModel page = mService.findByPK(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}

	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)SysAccountModel model) {
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
	public Result add(@RequestBody(required=true)SysAccountModel model) {
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
	public Result update(@RequestBody(required=true)SysAccountModel model) {
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
	public Result queryByPage(@RequestBody(required=true)Param<SysAccountModel> param, BindingResult bindResult) {
		Result rs = new Result();
		try{
            checkBindResult(bindResult);
            checkParam(param);
            SysAccountModel model = param.getData();
            PageBean<SysAccountModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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



    @ResponseBody
    @RequestMapping(value="/login")
    public Result login(HttpServletRequest request, @RequestBody(required=true) SysAccountVO model) {
        Result rs = new Result();
        try {
            SysAccountVO result = loginService.login(request, model);
            rs = new Result(result);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }


    @ResponseBody
    @RequestMapping(value="/logout")
    public Result logout(HttpServletRequest request, @RequestBody(required=true) SysAccountVO model) {
        Result rs = new Result();
        try {
            loginService.logout(request, model);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }


    /**
     * 修改密码
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/update-password")
    public Result updatePassword(@RequestBody(required=true) SysAccountUpdateVO model) {
        Result rs = new Result();
        try{
            mService.updatePassword(model);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }


    /**
     * 重置密码
     * @param list
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/reset-password")
    public Result resetPassword(@RequestBody(required=true)List<SysAccountModel> list) {
        Result rs = new Result();
        try {
            mService.resetPassword(list);
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }
        return rs;
    }



}