package com.cailu.springboot.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cailu.springboot.common.controller.BaseController;
import com.cailu.springboot.entity.Moudle;
import com.cailu.springboot.entity.Project;
import com.cailu.springboot.service.IMoudleService;
@Controller
@RequestMapping(value="/moudle") 
public class MoudleController extends BaseController{
	
	@Autowired
	public IMoudleService moudleService;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public String list(Model model) {
		List<Moudle> moudleList=moudleService.getMoudleList(Integer.parseInt(getSessionProjectId()));
		model.addAttribute("moudleList", moudleList);
		return "moudle/list";
		
	}
	
	@RequestMapping(value={"/add"}, method=RequestMethod.GET)
	public String add() {
		return "moudle/add";
		
	}
	@RequestMapping(value={"/insert"}, method=RequestMethod.POST)
	@ResponseBody
	public String insert(Moudle moudle) {

		JSONObject json=new JSONObject();
		moudle.setCreateUser(getSessionUser().getId());
		moudle.setUpdateUser(getSessionUser().getId());
		moudle.setProjectId(Integer.parseInt(getSessionProjectId()));
		moudleService.insert(moudle);
		if(moudle.getId()!=0) {
			json.put("message", "添加成功");
		}
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/detail"}, method=RequestMethod.GET)
	public String detail(int id,Model model) {
		Moudle moudle=moudleService.getMoudleById(id);
		if(moudle!=null) {
			model.addAttribute("moudle", moudle);
		}
		return "moudle/detail";
		
	}
	
	@RequestMapping(value={"/update"}, method=RequestMethod.POST)
	@ResponseBody
	public String update(Moudle moudle) {
		JSONObject json=new JSONObject();
		moudleService.update(moudle);
		json.put("message", "修改成功");
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/del"}, method=RequestMethod.GET)
	public String del(int id,Model model) {
		moudleService.delete(id);
		model.addAttribute("success","删除成功");
		return "moudle/list";
	}

}
