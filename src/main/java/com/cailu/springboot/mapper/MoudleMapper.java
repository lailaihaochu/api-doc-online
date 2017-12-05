package com.cailu.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cailu.springboot.entity.Moudle;

public interface MoudleMapper {


	public Moudle getMoudleById(int id);
	
	public List<Moudle> getMoudleList(int projectId);
	
	public Integer insert(Moudle moudle);
	
	public Integer update(Moudle moudle );
	
	public Integer delete(int id);

}
