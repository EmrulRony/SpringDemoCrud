package com.solutionia.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.solutionia.springcrud.entity.Customer;
import com.solutionia.springcrud.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers=service.getCustomers();
		
		model.addAttribute("customersList", customers);
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
	
	@GetMapping("/showCustomerUpdateForm")
	public String viewCustomerUpdateForm(@RequestParam("customerId") int customerId,Model model) {
		Customer theCustomer = service.findCustomer(customerId);
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@GetMapping("/deleteCustomer")
	public String deleteCusomer(@RequestParam("customerId") int customerId,Model model) {
		service.deleteCustomer(customerId);
//		List<Customer> customers = service.getCustomers();
//		model.addAttribute("customersList", customers);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/searchProcess")
	public String searchByName(@RequestParam("theSearchName") String theSearchName,Model model) {
		List<Customer> cusSearchList=service.searchCustomer(theSearchName);
		model.addAttribute("customersList", cusSearchList);
		return "list-customers";
	}
	
}
