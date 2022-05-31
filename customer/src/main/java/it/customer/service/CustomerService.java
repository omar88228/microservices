package it.customer.service;

import java.util.List;

import it.customer.entity.Customer;

public interface CustomerService {
	Customer add(Customer customer);
	List<Customer> showAll();
	Customer showById(int id);
	Customer deleteById(int id);
}
