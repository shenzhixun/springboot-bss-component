package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiApiCategoryModel;
public interface IBiApiCategoryService { 


	public void insertAutoKey(BiApiCategoryModel model) throws CoBusinessException; 

	public void update(BiApiCategoryModel model) throws CoBusinessException;

	public void delete(BiApiCategoryModel model) throws CoBusinessException; 

	public List<BiApiCategoryModel>  queryByCond(BiApiCategoryModel model) throws CoBusinessException;


}