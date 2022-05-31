package it.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.customer.entity.Customer;
import it.customer.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {

		this.repository = repository;
	}

	@Override
	public Customer add(Customer customer) {		
		return repository.save(customer);
	}

	@Override
	public List<Customer> showAll() {	
		return repository.findAll();
	}

	@Override
	public Customer showById(int id) {
		Optional<Customer> customer = repository.findById(id);
		return customer.get();
	}

	@Override
	public Customer deleteById(int id) {
		Optional<Customer> customer = repository.findById(id);
		repository.delete(customer.get());
		return customer.get();
	}

}
