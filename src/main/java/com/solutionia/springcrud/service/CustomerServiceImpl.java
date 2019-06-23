package com.solutionia.springcrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutionia.springcrud.dao.CustomerDao;
import com.solutionia.springcrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao dao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return dao.listCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer findCustomer(int customerId) {
		Customer customer = dao.getCustomer(customerId);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		dao.delCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchName) {
		return dao.searchList(searchName);
	}

}
