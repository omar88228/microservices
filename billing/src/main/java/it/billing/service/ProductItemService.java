package it.billing.service;

import java.util.List;
import it.billing.entity.ProductItem;

public interface ProductItemService {
	ProductItem add(ProductItem productItem);
	List<ProductItem>showAll();
	ProductItem showById(int id);
	ProductItem deleteById(int id);
	ProductItem updateById(int id,ProductItem productItem);
	ProductItem updatePrice(int id,double price);
	ProductItem updateQuantity(int id,int quantity);
}
