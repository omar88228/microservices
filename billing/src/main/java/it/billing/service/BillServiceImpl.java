package it.billing.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.billing.entity.Bill;
import it.billing.entity.Customer;
import it.billing.entity.Product;
import it.billing.entity.ProductItem;
import it.billing.openfeign.CustomerRestClient;
import it.billing.openfeign.ProductRestClient;
import it.billing.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	private BillRepository repository;
	private ProductItemService productItemService;
	private CustomerRestClient customerRestClient;
	private ProductRestClient productRestClient;

	@Autowired
	public BillServiceImpl(BillRepository repository, ProductItemService productItemService,
			CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
		super();
		this.repository = repository;
		this.productItemService = productItemService;
		this.customerRestClient = customerRestClient;
		this.productRestClient = productRestClient;
	}

	@Override
	public Bill add(Bill bill) {
		setCustomer(bill);
		List<ProductItem> productItems = bill.getProductIthems();
		productItems.stream().forEach(productItem -> {
			productItemService.add(productItem);
		});
		return repository.save(bill);
	}

	@Override
	public List<Bill> showAll() {
		List<Bill> bills = repository.findAll();
		for (Bill bill : bills) {
			setCustomer(bill);
			setProduct(bill);
		}
		return bills;
	}

	@Override
	public Bill showById(int id) {
		Bill bill = repository.findById(id).get();
		setProduct(bill);
		setCustomer(bill);
		return bill;
	}

	@Override
	public Bill deleteById(int id) {
		Bill bill = repository.findById(id).get();
		setProduct(bill);
		setCustomer(bill);
		repository.delete(bill);
		return bill;
	}

	@Override
	public Bill addProductItem(int id, int productItemId) {
		Bill bill = repository.findById(id).get();
		ProductItem productItem = productItemService.showById(productItemId);
		List<ProductItem>billProductItems=bill.getProductIthems();
		billProductItems.add(productItem);
		return add(bill);
	}

	@Override
	public Bill updateBillCustomerId(int id, int customerId) {
		Bill bill = repository.findById(id).get();
		bill.setCustomerId(customerId);
		return add(bill);
	}

	@Override
	public Bill updateBillingDate(int id, Date date) {
		Bill bill = repository.findById(id).get();
		bill.setBillingDate(date);
		return add(bill);
	}
	
	private void setCustomer(Bill bill) {
		Customer customer = customerRestClient.getCustomer(bill.getCustomerId());
		bill.setCustomer(customer);
	}

	private void setProduct(Bill bill) {
		List<ProductItem> customerProductItems = bill.getProductIthems();
		for (ProductItem customerProductItem : customerProductItems) {
			Product product = productRestClient.getProduct(customerProductItem.getProductId());
			customerProductItem.setProduct(product);
		}
	}

}
