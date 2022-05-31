package it.billing.openfeign;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.billing.entity.Customer;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
	@GetMapping(path = "/customersApi/customers/{id}")
	Customer getCustomer(@PathVariable(name = "id") int id);
	@GetMapping(path = "/customersApi/customers")
	List<Customer> getAllCustomer();
}
