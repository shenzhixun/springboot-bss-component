package com.ejet.bi.dynamicservice.service;

import java.util.List;

import com.ejet.bi.dynamicservice.vo.BiApiVO;
import com.ejet.bi.dynamicservice.vo.BiResourceVO;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bi.dynamicservice.model.BiResourceModel;
public interface IBiResourceService { 


	public void insertAutoKey(BiResourceModel model) throws CoBusinessException; 

	public void update(BiResourceModel model) throws CoBusinessException;

	public void delete(BiResourceModel model) throws CoBusinessException; 

	public List<BiResourceModel>  queryByCond(BiResourceModel model) throws CoBusinessException;

    public List<BiResourceVO> queryResouceBatch(List<BiApiVO> list) throws CoBusinessException;

}