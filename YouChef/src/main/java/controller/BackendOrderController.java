package controller;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.OrderDishesService;
import model.OrdersBean;
import model.OrdersDAO;
import model.OrdersService;


@Controller
public class BackendOrderController {
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderDishesService orderDishesService;
	
	@RequestMapping(value="/backEndOrder.controller")
	public String listAll( Model model) {
		List<OrdersBean> all = ordersDAO.getAll();
		model.addAttribute("ordersAll", all);
		return "orders.show";	
		}
	
	//預設0  取消1 已結帳2 放鳥 3 
	@RequestMapping(value="/maintain.controller")
	public String update( String o_id, String o_status,Model model) {		
		OrdersBean single = ordersDAO.findByPrimaryKey(Integer.valueOf(o_id));	
		single.setO_status(o_status);
		if (o_status.equals("2")){
			ordersService.completeOrder(single);
		}
		else if (o_status.equals("3")){
			ordersService.standUpOrder(single);
		}
		List<OrdersBean> all = ordersDAO.getAll();
		model.addAttribute("ordersAll", all);
		return "orders.show";

		}
	
	@RequestMapping (value="/memberOrders.controller")
	public String orderHistory (String m_id, Model model, HttpSession session){
		List<Object[]> result= orderDishesService.listOrderHostory(Integer.valueOf(m_id));
		session.setAttribute("memOrdersAll", result);
		return "memorders.show";
	}
	
	@RequestMapping (value="/memOrdersDetail.controller")
	public String orderDeatails (String o_id, Model model){
			List <Object[]> result= orderDishesService.listSingleOrderDetail(Integer.valueOf(o_id));
			model.addAttribute("orderDetail",result);
		return "orderDetail.show";
	}

	@RequestMapping(value="/cancelOrder.controller")
	public String cancel( String o_id, String o_status,Model model) {		
		OrdersBean single = ordersDAO.findByPrimaryKey(Integer.valueOf(o_id));	
		single.setO_status(o_status);
		ordersService.cancelOrder(single);
		if(single.getChefBean()!=null){
			ordersService.updateChefShift(single);
		}else{
			ordersService.updateMChefShift(single);
		}
		List<OrdersBean> all = ordersDAO.getAll();
		model.addAttribute("ordersAll", all);
		return "memorders.show";

		}
	
//	@RequestMapping(value="/orderDetails.controller")
//	public void listAllMember( Model model) {
//		List<OrdersBean> all = ordersDAO.getAll();
//		model.addAttribute("ordersAll", all);
//		}
}

