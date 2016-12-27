package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.DiscussBean;
import model.DiscussService;
import model.EssayBean;
import model.EssayService;

@Controller
@RequestMapping(path = { "/pages/getdiscuss.controller" })
public class GetDiscussController {
	@Autowired
	DiscussService discussService;
	@Autowired
	EssayService essayService;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		System.out.println("Start to initbinder");
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
	public String process(DiscussBean bean, BindingResult bindingResult, Model model, HttpServletRequest request) {
		//驗證
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		List<DiscussBean> elist = discussService.selectAll();
		System.out.println("elist="+elist);
		
		HttpSession session = request.getSession();
		session.setAttribute("elist", elist);
		return "essaytitle";
	}
}
