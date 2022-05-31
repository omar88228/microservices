package it.billing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.billing.entity.ProductItem;
import it.billing.service.ProductItemService;

@RestController
@RequestMapping("/ProductItemApi")
@Tag(name = "ProductItemApi ", description = " ProductItemApi API")
public class ProductItemController {
	
	private ProductItemService itemService;

	@Autowired
	public ProductItemController(ProductItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@PostMapping("/productItems/new")
	public ProductItem addProductIthem(@RequestBody ProductItem productIthem) {
		return itemService.add(productIthem);
	}

	@GetMapping("/productItems")
	public List<ProductItem> showAllProductIthems() {
		return itemService.showAll();
	}

	@GetMapping("/productItems/{id}")
	public ProductItem showProductIthemById(@PathVariable("id") int id) {
		return itemService.showById(id);
	}

	@DeleteMapping("/productItems/{id}")
	public ProductItem deleteProductIthemById(@PathVariable("id") int id) {
		return itemService.deleteById(id);
	}
	@PutMapping("/productItems/{id}")
	public ProductItem updateProductItem(@PathVariable("id") int id ,@RequestBody ProductItem productItem) {
		return itemService.updateById(id, productItem);
		
	}
	@PatchMapping("/productItems/price/{id}/{price}")
	public ProductItem updatePrice(@PathVariable("id") int id,@PathVariable("price") double price) {
		return itemService.updatePrice(id, price);
	}
	@PatchMapping("/productItems/quantity/{id}/{quantity}")
	public ProductItem updateQuantity(@PathVariable("id") int id,@PathVariable("quantity") int quantity) {
		return itemService.updateQuantity(id, quantity);
	}
	

}
