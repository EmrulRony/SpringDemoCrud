package com.solutionia.springcrud.dao;

import java.util.List;

import com.solutionia.springcrud.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> listCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int customerId);
	public void delCustomer(int customerId);
	public List<Customer> searchList(String searchName);
}
