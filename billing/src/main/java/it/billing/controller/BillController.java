package it.billing.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.billing.entity.Bill;
import it.billing.service.BillService;

@RestController
@RequestMapping("/billingApi")
@Tag(name = "billingApi ", description = " billing API")
public class BillController {
	BillService billService;

	@Autowired
	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}

	@PostMapping("bills/new")
	public Bill addBill(@RequestBody Bill bill) {
		return billService.add(bill);
	}

	@GetMapping("/bills")
	public List<Bill> showAllBills() {
		return billService.showAll();
	}

	@GetMapping("/bills/{id}")
	public Bill showBillById(@PathVariable("id") int id) {
		return billService.showById(id);
	}

	@DeleteMapping("/bills/{id}")
	public Bill deleteBillById(@PathVariable("id") int id) {
		return billService.deleteById(id);
	}
	
	@PatchMapping("/bills/{id}/productItem/{productItemId}")
	public Bill addProductItem(@PathVariable("id")int id,@PathVariable("productItemId") int productItemId) {
		return billService.addProductItem(id, productItemId);
	}
	@PatchMapping("/bills/CustomerId/{id}/{customerId}")
	public Bill updateBillCustomerId(@PathVariable("id") int id, @PathVariable("customerId") int customerId) {
		return billService.updateBillCustomerId(id, customerId);
	}
	@PatchMapping("/bills/billingDate/{id}")
	public Bill updateBillingDate(@PathVariable("id") int id,@RequestBody Date date) {
		return billService.updateBillingDate(id, date);
	}


}
