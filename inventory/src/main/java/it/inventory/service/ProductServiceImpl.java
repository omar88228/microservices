package it.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.inventory.entity.Product;
import it.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;

	@Autowired
	public ProductServiceImpl(ProductRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Product add(Product product) {

		return repository.save(product);
	}

	@Override
	public List<Product> showAll() {
		
		return repository.findAll();
	}

	@Override
	public Product showById(int id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}

	@Override
	public Product deleteById(int id) {
		Optional<Product> product = repository.findById(id);
		repository.delete(product.get());
		return product.get();
	}

}
