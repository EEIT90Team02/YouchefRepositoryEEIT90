package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.ChefBean;
import model.ChefService;


@Controller
public class ChefviewController2 {
	@Autowired
	ChefService chefService;
	
	
	@RequestMapping(
			path={"/chefdisplay/chefview2.controller"},
			method={RequestMethod.GET, RequestMethod.POST}
		)
	public String service(
			Model model,
			HttpSession session
		){
		List<ChefBean> select = (List<ChefBean>) chefService.select();
		session.setAttribute("list",select);
	return "selectChef2";
	}
	@RequestMapping(
			path={"/chefdisplay/selectChef.controller2"},
			method={RequestMethod.GET, RequestMethod.POST}
		)
	public String selectChef(
			@RequestParam(name="c_id") String temp1,
			Model model, HttpSession session
			){
			int c_id = 0;
			if(temp1!=null && temp1.length()!=0){
			c_id= Integer.parseInt(temp1);
			}
			ChefBean ch = chefService.select(c_id);
			session.setAttribute("chef",ch);
		return "selectChef3";
	}
	@RequestMapping(
			path={"/chefdisplay/selectChefByType.controller2"},
			method={RequestMethod.GET, RequestMethod.POST}
		)
	public String selectChefByType(
			Model model,
			HttpServletRequest request, 
			HttpServletResponse response
			){
		Integer type = Integer.parseInt(request.getParameter("id")); 
		List<ChefBean> selectChefByType = chefService.selectChefByType(type);
		model.addAttribute("ChefByType",selectChefByType);
	return "chef.selectChefByType2";
	}
}
