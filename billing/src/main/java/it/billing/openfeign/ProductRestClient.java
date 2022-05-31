package it.billing.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import it.billing.entity.Product;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
	@GetMapping(path = "/productApi/products/{id}")                             
	Product getProduct(@PathVariable(name = "id") int id);
	@GetMapping(path = "/productApi/products")
	List<Product> getAllProduct();
}
