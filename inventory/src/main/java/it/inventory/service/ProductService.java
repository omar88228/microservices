package it.inventory.service;

import java.util.List;
import it.inventory.entity.Product;

public interface ProductService {
	Product add(Product product);
	List<Product> showAll();
	Product showById(int id);
	Product deleteById(int id);
}
