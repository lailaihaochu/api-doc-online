package com.cailu.springboot.contorller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cailu.springboot.common.controller.BaseController;
import com.cailu.springboot.entity.User;
import com.cailu.springboot.service.IUserService;


@Controller
@RequestMapping(value="/user") 
public class UserController extends BaseController{

	
	@Autowired
	public IUserService userService;
	
	 @RequestMapping(value={"/"}, method=RequestMethod.GET)
	 public String login() {
		 
		 return "login";
	  }
	
    @RequestMapping(value={"/login"}, method=RequestMethod.POST)
    @Cacheable("user-jcc")
    public String userList(User user) {
    	/*UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUsername(),user.getPassword());*/
        Subject subject = SecurityUtils.getSubject();
        String result = "login";  
        if (!subject.isAuthenticated()) {  
            result = login(subject,user.getUsername(),user.getPassword());  
            logger.info("login : "+result);
            return "redirect:/project/list";
        }else{//重复登录  
        	User shiroUser = (User) subject.getPrincipal(); 
        	if(shiroUser.getUsername()!=null&&!shiroUser.getUsername().equals(user.getUsername())) {
        		 result = login(subject,user.getUsername(),user.getPassword());  
        		 logger.info("login : "+result);
        		 return "redirect:/project/list";
        	}
            /*User shiroUser = (User) subject.getPrincipal();  
            if(!shiroUser.getLoginName().equalsIgnoreCase(username)){//如果登录名不同  
                currentUser.logout();  
                result = login(subject,user.getUsername(),user.getPassword());  
            }*/  
        }  
    	//User u=userService.getUserLogin(user);
      /*  try {
			subject.login(usernamePasswordToken);   //完成登录
			User u=(User) subject.getPrincipal();
			session.setAttribute("user", u);
			logger.info("登录成功");
			return "redirect:/project/list";
		} catch (AuthenticationException e) {
			 logger.info("登录失败");
			 return "login";
		}*/
        logger.info("login : "+result);
        return "login";
    	
    }
    
    @SuppressWarnings("unused")
	private String login(Subject currentUser,String username,String password){  
        String result = "login";  
        UsernamePasswordToken token = new UsernamePasswordToken(username,  
                password);  
        token.setRememberMe(false);  
        try {  
            currentUser.login(token);  
            result = "success";  
        } catch (UnknownAccountException uae) {  
            result = "failure";  
        } catch (IncorrectCredentialsException ice) {  
            result = "failure";  
        } catch (LockedAccountException lae) {  
            result = "failure";  
        } catch (AuthenticationException ae) {  
            result = "failure";  
        }  
        return result;  
    }
	
    @RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(User user){
    	userService.insert(user);
    	/*userService.insert(user);*/
		return "login";
	}
    
    @RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(User user){
		return "register";
	}
	
	
	/*
	  @ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, 
	  				response = “接口返回参数类型”, notes = “接口发布说明”； 
	  @ApiParam(required = “是否必须参数”, name = “参数名称”, value = “参数具体描述” 
	 
	@ApiOperation(value="创建用户",notes="根据User对象创建用户")
	@ApiImplicitParam(required = true ,name="user",value = "用户详细实体user", dataType = "User")
	@RequestMapping(value="", method=RequestMethod.POST)
	public Integer postUser(@RequestBody User user){
		return userService.insert(user);
	}
	
	@ApiOperation(value="获取用户详细信息",notes="根据url中的ID参数来获取用户的详细信息")
	@RequestMapping(value="getById/{id}",method=RequestMethod.GET)
	public User getUserById(@ApiParam(value = "用户ID", required = true) @PathVariable Long id){
		return userService.getUserById(id);
	}
	
	@ApiOperation(value="更新用户详细信息",notes="根据URL中ID的参数值来指定对象，并根据USER传过来的参数信息来现实更新")
	@RequestMapping(value="updateById/{userId}",method=RequestMethod.PUT)
	public Integer updateUser(
			@ApiParam(value = "用户ID", required = true) @PathVariable(value = "userId") Long userId,
			@ApiParam(value = "用户详细实体user", required = true) @RequestBody User user ){
		return userService.updateUser(userId, user);
		
	}
	 
	@ApiOperation(value="第二种更新用户详细信息所有信息放在一个Bean中",notes="根据URL中ID的参数值来指定对象，并根据USER传过来的参数信息来现实更新")
	@RequestMapping(value="updateById2/{userId}",method=RequestMethod.PUT)
	public Integer updateUser2(
			@ApiParam(value = "用户详细实体user", required = true) @RequestBody User user ){
		return userService.updateUser2(user);
		
	}
	
	@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="deleteUserById/{Id}", method=RequestMethod.DELETE)
	 public Integer deleteUserById(@ApiParam(value = "用户ID", required = true) @PathVariable(value = "Id")Long id){
		return userService.deleteUserById(id);
		 
	 }*/
}
