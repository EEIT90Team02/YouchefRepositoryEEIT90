package model.dao;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.EssayBean;
import model.EssayDAO;
import model.InboxBean;

@Repository(value = "essayDao")
public class EssayDAOHibernate implements EssayDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public EssayBean select(EssayBean bean) {
		return this.getSession().get(EssayBean.class, bean.getEssay_id());
//		return this.getSession().get(EssayBean.class, 8002);
	}
	
	@Override
	public int insert(EssayBean bean) {
		return (int) this.getSession().save(bean);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EssayBean> selectAll() {
		Query query = this.getSession().createQuery("from EssayBean");
		return (List<EssayBean>) query.getResultList();
	}
	
	@Override
	public EssayBean update(EssayBean bean) {
		if (null != select(bean))  {
			getSession().clear();
			this.getSession().update(bean);
			return select(bean);
		}else{
			return null;
		}
	}
	@Override
	public boolean delete(int essay_id, String e_status) {
		EssayBean bean=null;
		bean = this.getSession().get(EssayBean.class, essay_id);
		if(bean!=null){
			bean.setE_status(e_status);
			return true;
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EssayBean> listAll() {
		Query listall = this.getSession().createQuery("from EssayBean where (e_status='0' or e_status='2') order by time DESC");
		return (List<EssayBean>) listall.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EssayBean> listBack() {
		Query listback = this.getSession().createQuery("from EssayBean where e_status='2' order by time DESC");
		return (List<EssayBean>) listback.getResultList();
	}
}
