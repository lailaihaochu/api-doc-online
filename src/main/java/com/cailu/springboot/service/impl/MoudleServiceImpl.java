package com.cailu.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cailu.springboot.entity.Moudle;
import com.cailu.springboot.mapper.IMoudleMapper;
import com.cailu.springboot.service.IMoudleService;
@Service
public class MoudleServiceImpl implements IMoudleService{
	
	@Autowired
	public IMoudleMapper moudleMapper;


	@Override
	public Moudle getMoudleById(int id) {
		// TODO Auto-generated method stub
		return moudleMapper.getMoudleById(id);
	}

	@Override
	public List<Moudle> getMoudleList(int projectId) {
		// TODO Auto-generated method stub
		return moudleMapper.getMoudleList(projectId);
	}

	@Override
	public Integer insert(Moudle moudle) {
		// TODO Auto-generated method stub
		return moudleMapper.insert(moudle);
	}

	@Override
	public Integer update(Moudle moudle) {
		// TODO Auto-generated method stub
		return moudleMapper.update(moudle);
	}

	@Override
	public Integer delete(int id) {
		// TODO Auto-generated method stub
		return moudleMapper.delete(id);
	}

}
