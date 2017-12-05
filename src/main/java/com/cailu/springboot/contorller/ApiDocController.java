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
import com.cailu.springboot.entity.ApiDoc;
import com.cailu.springboot.service.IApiDocService;
@Controller
@RequestMapping(value="/api") 
public class ApiDocController extends BaseController{
	
	@Autowired
	public IApiDocService apiDocService;
	
	@RequestMapping(value={"/list"})
	public String list(int moudleId,Model model) {
		List<ApiDoc> apiList=apiDocService.getApiDocList(moudleId);
		if(apiList!=null&&apiList.size()>0) {
			model.addAttribute("apiList", apiList);
			model.addAttribute("moudleId", moudleId);
		}
		return "api/list";
		
	}
	@RequestMapping(value={"/add"}, method=RequestMethod.GET)
	public String add(int moudleId,Model model) {
		model.addAttribute("moudleId", moudleId);
		return "api/add";
	}
	
	@RequestMapping(value={"/insert"}, method=RequestMethod.POST)
	@ResponseBody
	public String insert(ApiDoc api,Model model) {
		JSONObject json=new JSONObject();
		api.setCreateUser(getSessionUser().getId());
		api.setUpdateUser(getSessionUser().getId());
		apiDocService.insert(api);
		if(api.getId()!=0) {
			json.put("message", "添加成功");
			json.put("moudleId", api.getMoudleId());
		}
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/detail"}, method=RequestMethod.GET)
	public String detail(int id,Model model) {
		ApiDoc api=apiDocService.getApiDocById(id);
		if(api!=null) {
			model.addAttribute("api", api);
		}
		return "api/detail";
		
	}
	
	@RequestMapping(value={"/update"}, method=RequestMethod.POST)
	@ResponseBody
	public String update(ApiDoc api,Model model) {
		JSONObject json=new JSONObject();
		apiDocService.update(api);
		json.put("message", "修改成功");
		json.put("moudleId", api.getMoudleId());
		return json.toJSONString();
		
	}
	
	@RequestMapping(value={"/del"}, method=RequestMethod.GET)
	public String del(int id,Model model) {
		apiDocService.delete(id);
		model.addAttribute("success","删除成功");
		return "api/del";
		
	}

}
