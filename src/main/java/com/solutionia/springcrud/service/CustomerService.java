package com.solutionia.springcrud.service;

import java.util.List;

import com.solutionia.springcrud.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
	public Customer findCustomer(int customerId);
	public void deleteCustomer(int customerId);
	public List<Customer> searchCustomer(String searchName);
}
