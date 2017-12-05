package com.cailu.springboot.service;

import java.util.List;

import com.cailu.springboot.entity.ApiDoc;

public interface IApiDocService {
	public ApiDoc getApiDocById(int id);
	
	public List<ApiDoc> getApiDocList(int moudleId);
	
	public Integer insert(ApiDoc apiDoc);
	
	public Integer update(ApiDoc apiDoc );
	
	public Integer delete(int id);
}
