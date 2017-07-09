package com.nextgen.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nextgen.dao.IBaseDAO;

/**
 * @author umamaheswarar NextGenHCM July 12, 2016
 * 
 *         This is a implementation of base dao ,it is used to implement the
 *         basic operation of entity
 */

@Repository
public class BaseDAOImpl<T> extends HibernateDaoSupport implements IBaseDAO<T> {

	@SuppressWarnings("unchecked")
	public <X> X findById(Class<T> clazz, Long id) throws HibernateException {
		return (X) getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> findById(Class<T> clazz, final Long... id) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz)
				.add(Restrictions.in("id", new ArrayList<>(Arrays.asList(id)))).list();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> findByColumn(Class<T> clazz, String column, Object value) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(column, value)).list();
	}
	
	@SuppressWarnings("unchecked")
	public <X> X findUniqueByColumn(Class<T> clazz, String column, Object value) throws HibernateException {
		return (X) getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(column, value)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public <X> List<X> findAll(Class<T> clazz) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz).list();
	}

	public Serializable save(T paramT) throws HibernateException {
		Session currentSession = getSessionFactory().getCurrentSession();
		Serializable serializable = currentSession.save(paramT);
		currentSession.flush();
		return serializable;
	}

	public void delete(T paramT) throws HibernateException {
		Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.delete(paramT);
		currentSession.flush();
	}

	public void saveOrUpdate(T paramT) throws HibernateException {
		Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.saveOrUpdate(paramT);
		currentSession.flush();
	}

	public void merge(T paramT) throws HibernateException {
		Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.merge(paramT);
		currentSession.flush();
	}

	@Resource(name = "sessionFactory")
	public void setBaseDaoSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
