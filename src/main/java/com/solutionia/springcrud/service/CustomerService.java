package com.solutionia.springcrud.service;

import java.util.List;

import com.solutionia.springcrud.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
}
