package com.cailu.springboot.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cailu.springboot.common.controller.BaseController;
import com.cailu.springboot.service.IMoudleService;

@Controller
@RequestMapping(value="/index") 
public class IndexController extends BaseController{
	@Autowired
	public IMoudleService moudleService;
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	 public String index(int projectId,String projectName,Model model) {
		session.setAttribute("projectId", projectId);
		session.setAttribute("projectName", projectName);
		model.addAttribute("moudleList", moudleService.getMoudleList(projectId));
		return "index";
	  }
	
	@RequestMapping(value={"/indexv"}, method=RequestMethod.GET)
	 public String indexv() {
		 return "index_v";
	  }

}
