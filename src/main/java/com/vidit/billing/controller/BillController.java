package com.vidit.billing.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidit.billing.entity.Bill;
import com.vidit.billing.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {

//    @Autowired
//	private BillService billService;
	
    private final BillService billService;
    
	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}


	//@GetMapping("/bills")
	@GetMapping
	public List<Bill> getAllBils(){
//		List<Bill> bills = new ArrayList<>();
//		bills.add(new Bill(1L,"Vidit Mathur", "BILL1001",1200.50,"PENDING",LocalDate.of(2026, 3, 20)));
//		bills.add(new Bill(2L,"Amit Sharma","BILL1002",850.00,"PAID",LocalDate.of(2026, 3, 15)));
//		
		return billService.getAllBils();
	}
	
	
	@PostMapping
	public Bill createBill(@RequestBody Bill bill) {
		//System.out.println("New Bill Received  " +bill);
		//return billService.createBill(bill);
		return billService.saveBill(bill);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill){
		Bill updatedBill = billService.updateBill(id, bill);
		if(updatedBill != null) {
	       return ResponseEntity.ok(updatedBill);		
		}
		return ResponseEntity.notFound().build();
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable Long id){
		boolean deleted = billService.deleteBill(id);
		
		if(deleted) {
		
			return ResponseEntity.ok("Bill deleted successfully");
		}
	
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
}
