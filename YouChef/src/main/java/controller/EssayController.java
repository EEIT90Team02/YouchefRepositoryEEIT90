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
import org.springframework.web.bind.annotation.RequestParam;

import model.DiscussBean;
import model.DiscussService;
import model.EssayBean;
import model.EssayService;
import model.InboxBean;
import model.InboxService;
import model.MemberBean;
import model.MemberDAO;
import model.MemberService;

@Controller
@RequestMapping(path = {"/essay"})
public class EssayController {
		@Autowired
		EssayService essayService;
		@Autowired
		DiscussService discussService;
		@Autowired
		InboxService inboxService;
		@Autowired
		MemberDAO memberDao;
		
		@InitBinder
		private void initBinder(WebDataBinder binder) {
			System.out.println("Start to initbinder");
			binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		}
		
		@RequestMapping(path={"/getessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST})
		public String process(EssayBean bean,
				BindingResult bindingResult, 
				Model model, HttpServletRequest request) {

			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);

			List<EssayBean> elist = essayService.listAll();
			HttpSession session = request.getSession();
			session.setAttribute("elist", elist);
			return "essaylist";
			
		}
	
		@RequestMapping(path={"/insertessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String insertprocess(
				@RequestParam(name="writer_id")String writer_id, 
				@RequestParam(name="title")String title,
				@RequestParam(name="content")String content,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer =(MemberBean) session.getAttribute("user");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
		if(title==null || title.length()==0 || content==null || content.length()==0){
			errors.put("content", "請輸入標題與內容");
		}
		if(errors!=null && !errors.isEmpty()){
			return "essayinsert";
		}
		EssayBean bean = new EssayBean();
		bean.setWriter_id(writer);
		bean.setTitle(title);
		long time = new java.util.Date().getTime();
		bean.setTime(new java.sql.Date(time));
		bean.setContent(content);
		bean.setE_status("0");
		essayService.insert(bean);
		session.setAttribute("essaybean", bean);

		List<EssayBean> elist = essayService.listAll();

		session.setAttribute("elist", elist);
		return "essayinsertsuccess";
		}
		
		@RequestMapping(path={"/selectessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String selectprocess(
				@RequestParam(name="essay_id")String essayid,
				Model model,HttpSession session){
			MemberBean writer =(MemberBean) session.getAttribute("user");
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);
			EssayBean bean = new EssayBean();
			int essay_id = Integer.parseInt(essayid);
			bean.setEssay_id(essay_id);
			bean=essayService.select(bean);
			session.setAttribute("essayPage", bean);
			List<DiscussBean> temp1 = discussService.discussAll(essay_id);
			session.setAttribute("discussList", temp1);
			return "essayselect";
		}
		
		@RequestMapping(path={"/updateessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String updateprocess(
				@RequestParam(name="essay_id")String essayid,
				@RequestParam(name="title")String title,
				@RequestParam(name="content")String content,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer =(MemberBean) session.getAttribute("user");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
		if(title==null || title.length()==0 || content==null || content.length()==0){
			errors.put("editcontent", "請輸入標題與內容");
		}
		if(errors!=null && !errors.isEmpty()){
			return "essayedit";
		}
		int essay_id = Integer.parseInt(essayid);
		EssayBean bean = new EssayBean();
		bean.setEssay_id(essay_id);
		bean=essayService.select(bean);
		bean.setTitle(title);
		long time = new java.util.Date().getTime();
		bean.setTime(new java.sql.Date(time));
		bean.setContent(content);
		essayService.update(bean);
		session.setAttribute("essaybean", bean);
		List<EssayBean> elist = essayService.listAll();
		session.setAttribute("elist", elist);
		return "essayinsertsuccess";
		}
		
		
		@RequestMapping(path={"/deleteessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String deleteprocess(
				@RequestParam(name="essay_id")String essayid,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer =(MemberBean) session.getAttribute("user");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
		
		int essay_id = Integer.parseInt(essayid);
		EssayBean bean = new EssayBean();
		bean.setEssay_id(essay_id);
		bean=essayService.select(bean);
		essayService.delete(essay_id, "1");
		session.setAttribute("essaybean", bean);
		List<EssayBean> elist = essayService.listAll();
		session.setAttribute("elist", elist);
		return "essayinsertsuccess";
		}
		
		@RequestMapping(path={"/reportessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String reportprocess(
				@RequestParam(name="essay_id")String essayid,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer =(MemberBean) session.getAttribute("user");
		EssayBean update = (EssayBean) session.getAttribute("essayPage");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
			MemberBean admin = memberDao.select("eeitgroup3@gmail.com");
		
			InboxBean bean = new InboxBean();
			bean.setSubject("這是一封檢舉信喔!!");
			bean.setContent("這篇文章不符合規定, 請做處理!!");
			bean.setI_status("0");
			long time= new java.util.Date().getTime();
			bean.setMail_time(new java.sql.Time(time));
			bean.setReceiver (admin);
			try {
				inboxService.sendMail(bean, writer, admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int essay_id = Integer.parseInt(essayid);
			EssayBean upbean = new EssayBean();
			upbean.setEssay_id(essay_id);
			upbean=essayService.select(upbean);
			upbean.setE_status("2");
			essayService.update(upbean);
			return "essayselect";
		}
		
		@RequestMapping(path={"/backessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String backprocess(
				@RequestParam(name="essay_id")String essayid,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer = (MemberBean) session.getAttribute("admin");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
		EssayBean bean = new EssayBean();
		int essay_id = Integer.valueOf(essayid);
		bean.setEssay_id(essay_id);
		bean=essayService.select(bean);
		MemberBean ban = memberDao.select(bean.getWriter_id().getM_id());
		InboxBean mail = new InboxBean();
		mail.setSubject("你的文章已被封鎖");
		mail.setContent("這篇文章不符合規定, 已被鎖定!!");
		mail.setI_status("0");
		long time= new java.util.Date().getTime();
		mail.setMail_time(new java.sql.Time(time));
		mail.setReceiver (ban);
		try {
			inboxService.sendMail(mail, writer, ban);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		essayService.delete(essay_id, "1");
		List<EssayBean> backlist = essayService.listBack();
		session.setAttribute("backlist", backlist);
		return "back.redirect";
		}
		
		@RequestMapping(path={"/getbackessay.controller"},
				method = {RequestMethod.GET, RequestMethod.POST}
		)
		public String getbackprocess(Model model, HttpSession session) {


			List<EssayBean> backlist = essayService.listBack();

			session.setAttribute("backlist", backlist);
			return "essayback";
			
		}
		
		
		
		@RequestMapping(path={"/backnothing.controller"},
				method = {RequestMethod.GET, RequestMethod.POST},
				produces="text/html;charset=utf-8")
		public String nothingprocess(
				@RequestParam(name="essay_id")String essayid,
				Model model, HttpSession session) throws InterruptedException {
		MemberBean writer =(MemberBean) session.getAttribute("user");
		Map<String,String> errors = new HashMap<String,String>();
		model.addAttribute("errors",errors);
		
		int essay_id = Integer.parseInt(essayid);
		EssayBean bean = new EssayBean();
		bean.setEssay_id(essay_id);
		bean=essayService.select(bean);
		essayService.delete(essay_id, "0");
		List<EssayBean> backlist = essayService.listBack();
		session.setAttribute("backlist", backlist);
		return "back.redirect";
		}
}
