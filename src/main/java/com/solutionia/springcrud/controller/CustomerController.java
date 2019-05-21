package com.solutionia.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solutionia.springcrud.dao.CustomerDao;
import com.solutionia.springcrud.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		int num=10;
		List<Customer> customers=customerDao.listCustomers();
		
//		for (Customer tmpCus: customers ) {
//			System.out.println(tmpCus.getFirstName()+"    "+tmpCus.getLastName());
//		}
		model.addAttribute("customersList", customers);

		model.addAttribute("num", num);
		return "list-customers";
	}

}
