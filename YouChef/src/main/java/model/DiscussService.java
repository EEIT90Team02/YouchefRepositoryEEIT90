package model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "discussService")
@Transactional
public class DiscussService {
	@Autowired 
	private DiscussDAO discussDao;
	
	@Autowired 
	private EssayDAO essayDao;
	
	@Autowired
	private MemberDAO memberDao;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			DiscussService service = (DiscussService) context.getBean("discussService");
			
//			MemberDAO memberDao = (MemberDAO) context.getBean("memberDAO");
//			EssayDAO Dao = (EssayDAO) context.getBean("essayDao");
			
			//test insert
//			DiscussBean bean = new DiscussBean();
//			EssayBean eb = new EssayBean();
//			eb.setEssay_id(8001);
//			eb = service.essayDao.select(eb);
//			bean.setEssayBean(eb);
//			MemberBean mb = new MemberBean();
//			mb=service.memberDao.select(1001);
//			bean.setMemberBean(mb);
//			bean.setContent("謝謝");
//			long time  = new java.util.Date().getTime();
//			bean.setTime(new java.sql.Date(time));
//			bean.setD_status("0");
//			System.out.println("DiscussBean = " + bean);
//			System.out.println(service.insert(bean));
			
			//selcet
//			DiscussBean bean = new DiscussBean();
//			bean.setDiscuss_id(9002);
//			DiscussBean db = service.select(bean);
//			System.out.println("DiscussBean = " + db);
			
			//selectAll
//			System.out.println(service.selectAll());
			
			//update
//			db.setContent("謝謝您");
//			System.out.println(service.update(db));
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}

	
	public DiscussBean select(DiscussBean bean) {
		return discussDao.select(bean);
	}
	public int insert(DiscussBean bean) {
		return discussDao.insert(bean);
	}
	public List<DiscussBean> selectAll() {
		List<DiscussBean> list = discussDao.selectAll();
		return list;
	}
	public DiscussBean update(DiscussBean bean){
		return discussDao.update(bean);
	}
	public List<DiscussBean> discussAll(Integer essayBean) {
		List<DiscussBean> list = discussDao.discussAll(essayBean);
		return list;
	}
	public boolean delete(int discuss_id, String d_status){
		return discussDao.delete(discuss_id, "1");
	}
}