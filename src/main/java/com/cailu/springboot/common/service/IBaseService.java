package com.cailu.springboot.common.service;

import java.util.List;

public interface IBaseService<T>{

	public Integer insert(T t);
	
	public Integer update(T t);
	
	public T getById(int id);
	
	public List<T> getList();
	
	public Integer del(int id);
}
