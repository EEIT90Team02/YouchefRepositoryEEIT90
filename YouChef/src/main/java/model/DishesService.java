package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//抓出MENU


@Service(value = "dishesService ")
@Transactional(transactionManager="transactionManager")
public class DishesService {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();

			DishesService service = (DishesService) context.getBean("dishesService");
			System.out.println(service.select(5006).getMenu());
			
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		}finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
		}
	@Autowired
	
	private DishesDAO dishesDao;
	@Transactional
	public DishesBean addin(DishesBean bean){
		DishesBean result=null;
		if(bean!=null){
			result = dishesDao.insert(bean);
		}
		return result;
	}
	@Transactional(readOnly=true)
	public List<DishesBean> select(DishesBean bean) {
		List<DishesBean> result = null;
		if(bean != null && bean.getD_id() !=0){
			DishesBean temp = dishesDao.selectDishById(bean.getD_id());
			if(temp !=null){
				result = new ArrayList<DishesBean>();
				result.add(temp);
			}
			}else{
				result = dishesDao.selectAllDishes();
			}
			return result;
		}
	@Transactional(readOnly=true)
	public List<DishesBean> selectAll() {
		List<DishesBean> list = dishesDao.selectAllDishes();
		return list;
	}	
	
	@Transactional(readOnly=true)
	public DishesBean  select(int d_id) {
		return dishesDao.selectDishById(d_id);
	}
	@Transactional(readOnly=true)
	public List<Object[]>  selectType(int t_id) {
		List<Object[]> list =dishesDao.selectDishesByType(t_id);
		return list;
	}
	@Transactional
	public DishesBean update(String d_name,String d_briefing,double price,String menu,TypeBean typeBean,
			String d_status) {
		return dishesDao.update(d_name,d_briefing,price,menu,typeBean,d_status);
	}
	@Transactional
	public DishesBean updatedish(DishesBean bean,String d_name, String d_briefing, double price, TypeBean typeBean, String d_status) {
		bean.setD_name(d_name);
		bean.setD_briefing(d_briefing);
		bean.setPrice(price);
		bean.setTypeBean(typeBean);
		bean.setD_status(d_status);
		dishesDao.updatedish(bean.getD_id(),bean.getD_name(),bean.getD_briefing(),bean.getPrice(),bean.getTypeBean(),bean.getD_status());
		return bean;
	}
	@Transactional(readOnly=true) 
	 public List<Object[]>  selectMchef(int m_id) { 
	  List<Object[]> list =dishesDao.selectDishesByMchef(m_id); 
	  return list; 
	 }
	@Transactional(readOnly=true)
	public List<Object[]>  selectMenuByType(int t_id) {
		List<Object[]> list =dishesDao.selectMenuByType(t_id);
		return list;
	}
}

