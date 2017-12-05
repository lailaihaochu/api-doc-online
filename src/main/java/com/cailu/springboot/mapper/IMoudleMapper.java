package com.cailu.springboot.mapper;

import java.util.List;


import com.cailu.springboot.entity.Moudle;

public interface IMoudleMapper {


	public Moudle getMoudleById(int id);
	
	public List<Moudle> getMoudleList(int projectId);
	
	public Integer insert(Moudle moudle);
	
	public Integer update(Moudle moudle );
	
	public Integer delete(int id);

}
