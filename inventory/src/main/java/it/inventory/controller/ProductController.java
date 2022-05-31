package it.inventory.controller;

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
import it.inventory.entity.Product;
import it.inventory.service.ProductService;

@RestController
@RequestMapping("/productApi")
@Tag(name = "productApi ", description = " pruduct API")
public class ProductController {
	private ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@PostMapping("/products/new")
	public Product addNewProduct(@RequestBody Product product) {
		return service.add(product);
	}

	@GetMapping("/products")
	public List<Product> showAllProducts() {
		return service.showAll();
	}

	@GetMapping("/products/{id}")
	public Product showProductById(@PathVariable("id") int id) {
		return service.showById(id);
	}

	@DeleteMapping("/products/{id}")
	public Product deleteProductById(@PathVariable("id") int id) {
		return service.deleteById(id);
	}

}
