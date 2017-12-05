package com.cailu.springboot.common.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cailu.springboot.common.mapper.IBaseMapper;
import com.cailu.springboot.common.service.IBaseService;

public class BaseServiceImpl<D extends IBaseMapper<T>,T> implements IBaseService<T>{
	@Autowired
	public D mapper;

	/**
	 * insert
	 */
	@Override
	public Integer insert(T t) {
		// TODO insert
		return mapper.insert(t);
	}

	/**
	 * update
	 */
	@Override
	public Integer update(T t) {
		// TODO update 
		return mapper.update(t);
	}

	/**
	 * select id from table
	 */
	@Override
	public T getById(int id) {
		// TODO select id from table
		return mapper.getById(id);
	}

	/**
	 * select list
	 */
	@Override
	public List<T> getList() {
		// TODO select list
		return mapper.getList();
	}

	/**
	 * delete
	 */
	@Override
	public Integer del(int id) {
		// TODO delete
		return mapper.del(id);
	}
	


}
