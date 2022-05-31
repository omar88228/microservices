package it.billing.service;

import java.util.Date;
import java.util.List;

import it.billing.entity.Bill;
import it.billing.entity.ProductItem;

public interface BillService {
	
	Bill add(Bill bill);
	List<Bill>showAll();
	Bill showById(int id);
	Bill deleteById(int id);
	Bill addProductItem(int id,int productItemId);
	Bill updateBillCustomerId(int idBill,int customerId);
	Bill updateBillingDate(int id ,Date date);
}
