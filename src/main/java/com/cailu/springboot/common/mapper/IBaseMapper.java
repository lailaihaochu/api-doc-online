package com.cailu.springboot.common.mapper;


import java.util.List;

public interface IBaseMapper<T> {


	public Integer insert(T t);
	public List<T> getList();
	
	public Integer update(T t);
	
	public T getById(int id);
	
	
	
	public Integer del(int id);

}
