package com.solutionia.springcrud.dao;

import java.util.List;

import com.solutionia.springcrud.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> listCustomers();
}
