package it.billing.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.billing.entity.Product;
import it.billing.entity.ProductItem;
import it.billing.openfeign.ProductRestClient;
import it.billing.repository.ProductItemRepository;

@Service
public class ProductItemServiceImpl implements ProductItemService {

	private ProductItemRepository repository;
	private ProductRestClient productRestClient;

	@Autowired
	public ProductItemServiceImpl(ProductItemRepository repository, ProductRestClient productRestClient) {
		super();
		this.repository = repository;
		this.productRestClient = productRestClient;
	}

	@Override
	public ProductItem add(ProductItem productIthem) {
		setProduct(productIthem);
		double productIthemPrice = productIthem.getQuantity()*productIthem.getProduct().getPrice();
		productIthem.setPrice(productIthemPrice );
		return repository.save(productIthem);
	}

	@Override
	public List<ProductItem> showAll() {
		List<ProductItem> productItems = repository.findAll();
		productItems.stream().forEach(productItem ->{setProduct(productItem);});
		return productItems;
	}

	@Override
	public ProductItem showById(int id) {
		ProductItem productItem = repository.findById(id).get();
		setProduct(productItem);
		return productItem;
	}

	@Override
	public ProductItem deleteById(int id) {
		ProductItem productItem = repository.findById(id).get();
		repository.delete(productItem);
		setProduct(productItem);
		return productItem;
	}

	@Override
	public ProductItem updateById(int id, ProductItem productItem) {
		ProductItem oldProductItem = repository.findById(id).get();
		oldProductItem.setPrice(productItem.getProductId());
		oldProductItem.setQuantity(productItem.getQuantity());
		
		return add(oldProductItem);
	}

	@Override
	public ProductItem updatePrice(int id, double price) {
		ProductItem oldProductItem = repository.findById(id).get();
		oldProductItem.setPrice(price);
		return add(oldProductItem);
	}

	@Override
	public ProductItem updateQuantity(int id, int quantity) {
		ProductItem oldProductItem = repository.findById(id).get();
		oldProductItem.setQuantity(quantity);
		return add(oldProductItem);
	}
	private void setProduct(ProductItem productItem) {
		Product product = productRestClient.getProduct(productItem.getProductId());
		productItem.setProduct(product);
	}

}
