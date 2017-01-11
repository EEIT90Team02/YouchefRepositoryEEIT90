package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.DishesBean;
import model.DishesService;
import model.misc.LeaveBean;

@Controller
@RequestMapping(path = { "/pages/getMenu.controller" })
public class GetMenuByDidController {
	@Autowired
	DishesService dishesService;
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public void process(LeaveBean bean, BindingResult bindingResult, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String menu = "";
		File file = new File("c:/youchef/menu/" + Integer.parseInt(request.getParameter("d_id")) + ".menu");
		if(file.exists()){
			Reader br = null;
			try {
				response.setContentType("text/html;charset=utf-8");
//				FileReader fr = new FileReader(file);
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				StringBuilder sb = new StringBuilder();
				while(br.ready()){
					sb.append((char)br.read());
				}
				response.getWriter().write(sb.toString());
				response.getWriter().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			DishesBean db = dishesService.select(Integer.parseInt(request.getParameter("d_id")));
			Writer out = null;
			try {
//				fw = new FileWriter("c:/youchef/menu/" + Integer.parseInt(request.getParameter("d_id")) + ".menu");
//				fw.write(db.getMenu());
//				fw.flush();
				out = new BufferedWriter(new OutputStreamWriter(
					    new FileOutputStream(file), "UTF-8"));
				out.write(db.getMenu());
				out.flush();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(db.getMenu());
				response.getWriter().flush();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally{
				if(null != out){
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
