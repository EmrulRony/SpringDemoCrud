package com.solutionia.springcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solutionia.springcrud.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> listCustomers() {

		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("SELECT c FROM Customer c",Customer.class);
		return query.getResultList();
	}

}
