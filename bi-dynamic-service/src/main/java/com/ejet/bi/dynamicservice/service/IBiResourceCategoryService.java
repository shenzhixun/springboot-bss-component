package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceCategoryModel;
public interface IBiResourceCategoryService { 


	public void insertAutoKey(BiResourceCategoryModel model) throws CoBusinessException; 

	public void update(BiResourceCategoryModel model) throws CoBusinessException;

	public void delete(BiResourceCategoryModel model) throws CoBusinessException; 

	public List<BiResourceCategoryModel>  queryByCond(BiResourceCategoryModel model) throws CoBusinessException;


}