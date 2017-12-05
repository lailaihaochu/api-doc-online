package com.cailu.springboot.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cailu.springboot.common.controller.BaseController;
import com.cailu.springboot.entity.Project;
import com.cailu.springboot.service.IProjectService;


@Controller
@RequestMapping(value="/project") 
public class ProjectController extends BaseController{
	
	@Autowired
	public IProjectService projectService;
	
	@RequestMapping(value={"/list"})
	public String list(Model model) {
		List<Project> proList=projectService.getProjectList();
		if(proList!=null&&proList.size()>0) {
			model.addAttribute("proList", proList);
		}
		return "project/list";
		
	}
	
	@RequestMapping(value={"/add"}, method=RequestMethod.GET)
	public String add() {
		return "project/add";
		
	}
	
	@RequestMapping(value={"/insert"}, method=RequestMethod.POST)
	@ResponseBody
	public String insert(Project project) {
		JSONObject json=new JSONObject();
		project.setCreateUser(getSessionUser().getId());
		project.setUpdateUser(getSessionUser().getId());
		projectService.insert(project);
		if(project.getId()!=0) {
			json.put("message", "添加成功");
		}
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/detail"}, method=RequestMethod.GET)
	public String detail(Project project,Model model) {
		Project pro=projectService.getProjectById(project.getId());
		if(pro!=null) {
			model.addAttribute("pro", pro);
		}
		return "project/detail";
		
	}
	
	@RequestMapping(value={"/update"}, method=RequestMethod.POST)
	@ResponseBody
	public String update(Project project) {
		JSONObject json=new JSONObject();
		projectService.update(project);
		json.put("message", "添加成功");
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/del"}, method=RequestMethod.GET)
	public String del(Project project,Model model) {
	
		projectService.delete(project.getId());
		model.addAttribute("success","删除成功");
		return "project/list";
		
	}

}
