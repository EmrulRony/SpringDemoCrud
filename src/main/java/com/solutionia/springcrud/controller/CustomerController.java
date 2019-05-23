package com.solutionia.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solutionia.springcrud.dao.CustomerDao;
import com.solutionia.springcrud.entity.Customer;
import com.solutionia.springcrud.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		int num=10;
		List<Customer> customers=service.getCustomers();
		
		model.addAttribute("customersList", customers);

		model.addAttribute("num", num);
		return "list-customers";
	}
	
	@GetMapping("/showCustomerAddForm")
	public String viewCustomerAddForm(Model model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		service.addCustomer(customer);
		
		return "redirect:/customer/list";
	}
	

}
