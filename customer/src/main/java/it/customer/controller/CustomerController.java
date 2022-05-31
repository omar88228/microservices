package it.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.customer.entity.Customer;
import it.customer.service.CustomerService;

@RestController
@RequestMapping("/customersApi")
@Tag(name = "customersApi ", description = " customers API")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/customers/new")
	public Customer addNewCustomer(@RequestBody Customer customer) {
		return service.add(customer);
	}
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return service.showAll();
	}
	@GetMapping("/customers/{id}")
	public Customer getCustomerById( @PathVariable("id") int id) {
		return service.showById(id);
	}
	@DeleteMapping("/customers/{id}")
	public Customer deleteCustomer(@PathVariable("id") int id) {
		return service.deleteById(id);
	}

}
