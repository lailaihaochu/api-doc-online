package com.cailu.springboot.service;

import java.util.List;

import com.cailu.springboot.common.service.IBaseService;
import com.cailu.springboot.entity.User;

public interface IUserService extends IBaseService<User> {

	public User getUserById(Long id);
	
	public List<User> getUserList();
	
	public User getUserLogin(User user);
	
	/*public Integer insert(User user);*/
	
	public Integer updateUser(Long userId,User user );
	
	public Integer updateUser2(User user);
	
	public Integer deleteUserById(Long id);

	public User findByUsername(String username);
}
