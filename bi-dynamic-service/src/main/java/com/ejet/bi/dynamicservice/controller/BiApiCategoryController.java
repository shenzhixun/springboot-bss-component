package com.ejet.bi.dynamicservice.controller;

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
import com.ejet.bi.dynamicservice.model.BiApiCategoryModel;
import com.ejet.bi.dynamicservice.service.impl.BiApiCategoryServiceImpl;
@RestController
@RequestMapping(value="/bi-api-category")
public class BiApiCategoryController extends CoBaseController { 

	private final Logger log = LoggerFactory.getLogger(BiApiCategoryController.class);
	@Autowired
	private BiApiCategoryServiceImpl mService;


	@ResponseBody
	@RequestMapping(value="/query")
	public Result query(@RequestBody(required=false)BiApiCategoryModel model) {
		Result rs = new Result();
		try {
			List<BiApiCategoryModel> page = mService.queryByCond(model);
			rs = new Result(page);
		}catch (CoBusinessException e) {
			log.error("", e);
			rs = new Result(e.getCode(), e);
		}
		return rs;
	}


	@ResponseBody
	@RequestMapping(value="/delete")
	public Result delete(@RequestBody(required=true)BiApiCategoryModel model) {
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
	public Result add(@RequestBody(required=true)BiApiCategoryModel model) {
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
	public Result update(@RequestBody(required=true)BiApiCategoryModel model) {
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
			BiApiCategoryModel model = toBean(param, new TypeReference<BiApiCategoryModel>(){});
			PageBean<BiApiCategoryModel> pageBean = mService.queryByPage(model, param.getPage().getPageNum(), param.getPage().getPageSize());
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


}