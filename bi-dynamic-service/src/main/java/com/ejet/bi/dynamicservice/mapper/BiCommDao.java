package com.ejet.bi.dynamicservice.mapper;

import com.ejet.comm.exception.CoBusinessException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BiCommDao {

	public int insertAutoKey(Object obj) throws CoBusinessException;

	public void update(Object obj) throws CoBusinessException;

	public void delete(Object obj) throws CoBusinessException;

	public abstract List<Map<String,Object>> queryByCond(Object obj) throws CoBusinessException;

	public abstract List<Map<String,Object>> queryByPage(Object obj) throws CoBusinessException;

    public Object insertBatch(Object list) throws CoBusinessException;


}