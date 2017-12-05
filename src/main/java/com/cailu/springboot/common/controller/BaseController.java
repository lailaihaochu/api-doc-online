package com.cailu.springboot.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cailu.springboot.Application;
import com.cailu.springboot.entity.User;

public class BaseController {
	public HttpServletRequest request;
	public HttpServletResponse response;
	public HttpSession session;
	public final static Logger logger = LoggerFactory.getLogger(Application.class); 
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,HttpServletResponse response) {
		this.request=request;
		this.response=response;
		this.session=this.request.getSession();
	}
	
	public User getSessionUser() {
		if(session!=null) {
			if(session.getAttribute("user")!=null) {
				logger.info("session缓存添加了user");
				return (User) session.getAttribute("user");
			}
		}
		return null;
	}
	
	public String getSessionProjectId() {
		if(session!=null) {
			if(session.getAttribute("projectId")!=null) {
				logger.info("session缓存添加了projectId");
				return String.valueOf(session.getAttribute("projectId"));
			}
		}
		return null;
	}
}
