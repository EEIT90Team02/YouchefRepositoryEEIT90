package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.ChefBean;
import model.ChefService;
import model.DishPhotoBean;
import model.DishPhotoService;
import model.MchefBean;
import model.MchefService;
import model.MemberBean;
import model.MemberService;
import model.misc.LeaveBean;

@Controller
@RequestMapping(path = { "/pages/getImage.controller" })
public class GetImageController {
	@Autowired
	ChefService chefService;
	@Autowired
	MchefService mchefService;
	@Autowired
	DishPhotoService dishPhotoService;
	@Autowired
	MemberService memberService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public void process(LeaveBean bean, BindingResult bindingResult, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		byte[] ba = new byte[819200];
		System.out.println("id = " + request.getParameter("id"));
		System.out.println("mc_id = " + request.getParameter("mc_id"));
		System.out.println("d_id = " + request.getParameter("d_id"));
		System.out.println("m_id = " + request.getParameter("m_id"));
		System.out.println("dp_id = " + request.getParameter("dp_id"));
		if (null != request.getParameter("id")) {
			File file = new File("c:/youchef/images/chef/" + request.getParameter("id") + ".jpg");
			if(file.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					fis.read(ba, 0, (int)file.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				ChefBean mb = chefService.select(Integer.parseInt(request.getParameter("id")));
				FileOutputStream fos = null;
				ba = mb.getPhoto();
				try {
					fos = new FileOutputStream(new File("c:/youchef/images/chef/" + request.getParameter("id") + ".jpg"));
					fos.write(ba);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					if(null != fos){
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
//			ChefBean cb = chefService.select(Integer.parseInt(request.getParameter("id")));
//			ba = cb.getPhoto();
		}else if(null != request.getParameter("mc_id")){
			File file = new File("c:/youchef/images/member/" + request.getParameter("mc_id") + ".jpg");
			if(file.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					fis.read(ba, 0, (int)file.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				MchefBean mb = mchefService.select(Integer.parseInt(request.getParameter("mc_id")));
				FileOutputStream fos = null;
				ba = mb.getMemberBean().getPhoto();
				try {
					fos = new FileOutputStream(new File("c:/youchef/images/member/" + request.getParameter("mc_id") + ".jpg"));
					fos.write(ba);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					if(null != fos){
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
//			MchefBean mb = mchefService.select(Integer.parseInt(request.getParameter("mc_id")));
//			ba = mb.getMemberBean().getPhoto();
		}else if(null != request.getParameter("d_id")){
			File file = new File("c:/youchef/images/dishes/" + request.getParameter("d_id") + "_0.jpg");
			if(file.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					fis.read(ba, 0, (int)file.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				List<DishPhotoBean> list = dishPhotoService.selectByDid(Integer.parseInt(request.getParameter("d_id")));
				for(int i = 0;i < list.size();i++){
					FileOutputStream fos = null;
					try {
						fos = new FileOutputStream(new File("c:/youchef/images/dishes/" + request.getParameter("d_id") + "_" + i + ".jpg"));
						fos.write(list.get(i).getD_photo());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						if(null != fos){
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				ba = list.get(0).getD_photo();
			}
//			List<DishPhotoBean> list = dishPhotoService.selectByDid(Integer.parseInt(request.getParameter("d_id")));
//			ba = list.get(0).getD_photo();
		}else if(null != request.getParameter("m_id")){
			File file = new File("c:/youchef/images/member/" + request.getParameter("m_id") + ".jpg");
			if(file.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					fis.read(ba, 0, (int)file.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				MemberBean mb = memberService.select(Integer.parseInt(request.getParameter("m_id")));
				FileOutputStream fos = null;
				ba = mb.getPhoto();
				try {
					fos = new FileOutputStream(new File("c:/youchef/images/member/" + request.getParameter("m_id") + ".jpg"));
					fos.write(ba);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					if(null != fos){
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
//			MemberBean mb = memberService.select(Integer.parseInt(request.getParameter("m_id")));
//			ba = mb.getPhoto();
		}else if(null != request.getParameter("dp_id")){
			File file = new File("c:/youchef/images/dishphoto/" + request.getParameter("dp_id") + ".jpg");
			if(file.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(file);
					fis.read(ba, 0, (int)file.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				DishPhotoBean mb = dishPhotoService.selectByDpid(Integer.parseInt(request.getParameter("dp_id")));
				FileOutputStream fos = null;
				ba = mb.getD_photo();
				try {
					fos = new FileOutputStream(new File("c:/youchef/images/dishphoto/" + request.getParameter("dp_id") + ".jpg"));
					fos.write(ba);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					if(null != fos){
						try {
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
//			DishPhotoBean mb = dishPhotoService.selectByDpid(Integer.parseInt(request.getParameter("dp_id")));
//			ba = mb.getD_photo();
		}
		
		response.setContentType("image/jpeg");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(ba);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
