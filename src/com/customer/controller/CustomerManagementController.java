package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerManagementController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customerList", customerList);
		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("mode", "Add");
		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("customerId") long customerId) {
		Customer customer = customerService.findById(customerId);
		model.addAttribute("customer", customer);
		model.addAttribute("mode", "Update");
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("customerId") long customerId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = null;
		if (customerId == 0) {
			customer = new Customer(firstName, lastName, email);

		} else {
			customer = customerService.findById(customerId);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}
		customerService.save(customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") long customerId) {
		customerService.delete(customerId);
		return "redirect:/customer/list";
	}

}
