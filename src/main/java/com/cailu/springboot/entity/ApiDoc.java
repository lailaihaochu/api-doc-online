package com.cailu.springboot.entity;

public class ApiDoc {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String description;
	private int createUser;
	private int updateUser;
	private String createTime;
	private String updateTime;
	private int moudleId;
	private String paramIn;
	private String paramOut;
	private String request;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
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
	public int getMoudleId() {
		return moudleId;
	}
	public void setMoudleId(int moudleId) {
		this.moudleId = moudleId;
	}
	public String getParamIn() {
		return paramIn;
	}
	public void setParamIn(String paramIn) {
		this.paramIn = paramIn;
	}
	public String getParamOut() {
		return paramOut;
	}
	public void setParamOut(String paramOut) {
		this.paramOut = paramOut;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
}
