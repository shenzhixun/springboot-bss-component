package com.ejet.bss.userflow.controller;

import com.ejet.bss.userflow.bo.BssApplyBO;
import com.ejet.bss.userflow.bo.BssFlowRequestBO;
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
import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userflow.service.impl.BssFlowServiceImpl;
@RestController
@RequestMapping(value="/bss-flow")
public class BssFlowController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(BssFlowController.class);
	@Autowired
	private BssFlowServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)BssFlowModel model) {
		Result rs = new Result();
		try {
			List<BssFlowModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)BssFlowModel model) {
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
	public Result add(@RequestBody(required=true)BssFlowModel model) {
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
	public Result update(@RequestBody(required=true)BssFlowModel model) {
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
	@RequestMapping(value="/query_by_page")
	public Result queryByPage(@RequestBody(required=true)Param<BssFlowModel> param, BindingResult bindResult) {
		Result rs = new Result();
		try{
			checkBindResult(bindResult);
			checkParam(param);
			BssFlowModel model = param.getData();
			PageBean<BssFlowModel> page = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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



    @ResponseBody
    @RequestMapping(value="/add-flow")
    public Result addFlow(@RequestBody(required=true)BssFlowRequestBO bo, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            mService.addFlow(bo);
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
     * 提交表单，进行审批
     * @param bo
     * @param bindResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/apply-buss")
    public Result applyBuss(@RequestBody(required=true) BssApplyBO bo, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            mService.applyBuss(bo);
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