package com.cailu.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cailu.springboot.entity.ApiDoc;
import com.cailu.springboot.mapper.IApiDocMapper;
import com.cailu.springboot.service.IApiDocService;
@Service
public class ApiDocServiceImpl implements IApiDocService{

	
	@Autowired
	public IApiDocMapper apiDocMapper;

	@Override
	public ApiDoc getApiDocById(int id) {
		// TODO Auto-generated method stub
		return apiDocMapper.getApiDocById(id);
	}

	@Override
	public List<ApiDoc> getApiDocList(int moudleId) {
		// TODO Auto-generated method stub
		return apiDocMapper.getApiDocList(moudleId);
	}

	@Override
	public Integer insert(ApiDoc apiDoc) {
		// TODO Auto-generated method stub
		return apiDocMapper.insert(apiDoc);
	}

	@Override
	public Integer update(ApiDoc apiDoc) {
		// TODO Auto-generated method stub
		return apiDocMapper.update(apiDoc);
	}

	@Override
	public Integer delete(int id) {
		// TODO Auto-generated method stub
		return apiDocMapper.delete(id);
	}

}
