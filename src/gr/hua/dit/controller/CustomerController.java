package gr.hua.dit.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		// add page title
		model.addAttribute("pageTitle", "List Customers");
		return "list-customers";
	}

	@GetMapping("/{id}")
	public String getCustomer(Model model, @PathVariable("id") int id) {
		// get the customer
		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		// add page title
		model.addAttribute("pageTitle", "Add Customer");
		return "customer-form";
	}


	@GetMapping("/showAddFormFromList")
	public String showAddFormFromList(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		// add page title
		model.addAttribute("pageTitle", "Add Customer");
		return "add-customer";
	}

	@Secured("ROLE_SEC")
	@GetMapping("/showDeleteForm")
	public String showDeleteForm(Model model) {
		// create model attribute to get form data
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		// add page title
		model.addAttribute("pageTitle", "List Customers");
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		// add page title
		model.addAttribute("pageTitle", "Delete Customer");
		return "delete-customer";
	}

	@Secured("ROLE_SEC")
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(HttpServletRequest request, @ModelAttribute("customer") Customer customer)
			throws ServletException, IOException {
		// create model attribute to get form data
		try {
			customerService.deleteCustomer(customer);
		} catch (java.lang.IllegalArgumentException e) {
			request.setAttribute("update_msg", "Username does not exist");
			return "redirect:/customer/showDeleteForm";
		}
		return "redirect:/user/secretariatForm";
	}

	@Secured("ROLE_SEC")
	@PostMapping("/deleteCustomer1")
	public String deleteCustomer1(HttpServletRequest request, @ModelAttribute("customer") Customer customer)
			throws ServletException, IOException {
		// create model attribute to get form data

		customerService.deleteCustomer(customer);

		return "redirect:/customer/list";
	}

	@Secured("ROLE_SEC")
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save the customer using the service
		customerService.saveCustomer(customer);

		return "redirect:/user/secretariatForm";
	}

	
	@PostMapping("/saveCustomerList")
	public String saveCustomerList(@ModelAttribute("customer") Customer customer) {
		// save the customer using the service
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showLoginForm")
	public String showLoginForm(HttpServletRequest request, Model model, HttpServletResponse response) {
		// create model attribute to get form data
		// User user = new User();
		// model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Login");
		return "login-form";
	}

}
