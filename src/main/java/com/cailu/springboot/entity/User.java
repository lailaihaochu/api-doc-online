package com.cailu.springboot.entity;


public class User {

	private int Id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private int userSex;
	
	private int age;
	
	private int isSuper;
	
	private String createTime;
	
	private String updateTime;
	
	private String token;

	



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIsSuper() {
		return isSuper;
	}

	public void setIsSuper(int isSuper) {
		this.isSuper = isSuper;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	



	
}
