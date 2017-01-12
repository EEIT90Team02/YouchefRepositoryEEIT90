package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service(value = "typeService")
@Transactional
public class TypeService {
	@Autowired
	DishPhotoService dishPhotoService;
	
	@Autowired
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {sessionFactory.getCurrentSession().beginTransaction();

		TypeService service = (TypeService) context.getBean("typeService");
		
		Set<DishesBean> set = service.typeDao.select(3002).getDishesBean();
		System.out.println(set);
		Iterator it = set.iterator();
		while(it.hasNext()){
			DishesBean db = (DishesBean)it.next();
			System.out.println(service.dishPhotoService.selectByDid(db.getD_id()).get(0).getD_photo());
		}
		
		
		sessionFactory.getCurrentSession().getTransaction().commit();
	}finally {
		sessionFactory.close();
		((ConfigurableApplicationContext) context).close();
	}
}
	@Autowired
	private TypeDAO typeDao;
	@Transactional(readOnly=true)
	public TypeBean select(int t_id) {
		return typeDao.select(t_id);
	}
	@Transactional
	public TypeBean insert(TypeBean typeBean){
		TypeBean result = null;
		if(typeBean != null){
			result = typeDao.insert(typeBean);
		}
		return result;
	}
	@Transactional(readOnly=true)
	public List<TypeBean> selectAll() {
		List<TypeBean> list = typeDao.select();
		return list;
	}
}

