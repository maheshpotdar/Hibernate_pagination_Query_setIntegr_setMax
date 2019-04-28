package com.mahesh.models;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		String hql = "FROM Employee";
		org.hibernate.Query<Employee> query = session.createQuery(hql);
		query.setFirstResult(3);//pagination.
		query.setFetchSize(4);//pagination.
		query.setMaxResults(2);//pagination.
		System.out.println(new Date());
		
		List<Employee> lstemployees=query.getResultList();
		System.out.println(lstemployees);
		session.close();

	}

}
