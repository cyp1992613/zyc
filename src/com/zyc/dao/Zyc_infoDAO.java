package com.zyc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zyc.entity.Zyc_info;

@Repository
@Transactional
public class Zyc_infoDAO {

	@Resource
	SessionFactory factory;

	public List<Zyc_info> findByProperty(String propertyName, Object value) {
		String queryString = "from Zyc_info as model where model."
				+ propertyName + "= ?";
		Query q = factory.getCurrentSession().createQuery(queryString);
		q.setParameter(0, value);
		return q.list();
	}
	
	public void saveOrUpdate(Zyc_info zyc_info){
		factory.getCurrentSession().saveOrUpdate(zyc_info);
	}
	
}
