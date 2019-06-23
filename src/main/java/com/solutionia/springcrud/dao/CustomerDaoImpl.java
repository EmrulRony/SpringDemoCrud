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
	public List<Customer> listCustomers() {

		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("SELECT c FROM Customer c ORDER BY last_name",Customer.class);
		return query.getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
//		session.save(customer);
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public void delCustomer(int customerId) {
		Session session=sessionFactory.getCurrentSession();
		
		session.remove(session.find(Customer.class, customerId));
	}

	@Override
	public List<Customer> searchList(String searchName) {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> theQuery = null;
		if (searchName!=null && searchName.trim().length()>0) {
			 theQuery=session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", searchName.toLowerCase());
		}
		else {
			theQuery=session.createQuery("from Customer", Customer.class);
		}
		return theQuery.getResultList();
	}

}
