package com.cailu.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cailu.springboot.common.service.impl.BaseServiceImpl;
import com.cailu.springboot.entity.User;
import com.cailu.springboot.mapper.IUserMapper;
import com.cailu.springboot.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<IUserMapper,User> implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
	}

	/*@Override
	public Integer insert(User user) {
		return userMapper.insert(user);
		
	}*/

	@Override
	public Integer updateUser(Long userId, User user) {
		/*User u = userMapper.getUserById(userId);
		u.setUserName(user.getUserName());
		u.setPassWord(user.getPassWord());
		u.setNickName(user.getNickName());*/
		return userMapper.updateUser(userId, null);
	}

	@Override
	public Integer updateUser2(User user) {
	/*	Long userId = user.getId();
		User u = userMapper.getUserById(userId);
		u.setUserName(user.getUserName());
		u.setPassWord(user.getPassWord());
		u.setNickName(user.getNickName());*/
		return userMapper.updateUser(null, user);
	}

	@Override
	public Integer deleteUserById(Long id) {
		return userMapper.deleteUserById(id);
	}

	@Override
	public User getUserLogin(User user) {
		return userMapper.getUserLogin(user);
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

}
