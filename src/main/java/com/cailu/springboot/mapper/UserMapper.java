package com.cailu.springboot.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cailu.springboot.entity.User;


public interface UserMapper {

	public User getUserById(Long id);
	
	public List<User> getUserList();
	
	public Integer insert(User user);
	
	public Integer updateUser(@Param("userId")Long userId, @Param("user")User user );
	
	public Integer deleteUserById(Long id);

	public User getUserLogin(User user);
}
