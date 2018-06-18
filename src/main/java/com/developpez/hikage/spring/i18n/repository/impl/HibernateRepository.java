package com.developpez.hikage.spring.i18n.repository.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class HibernateRepository {

	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
