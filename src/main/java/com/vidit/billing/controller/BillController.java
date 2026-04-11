package com.vidit.billing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidit.billing.dto.BillResponseDto;
import com.vidit.billing.dto.BillingRequestDto;
import com.vidit.billing.service.BillService;

import jakarta.validation.Valid;

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


//	//@GetMapping("/bills")
//	@GetMapping
//	public List<BillResponseDto> getAllBills(){
////		List<Bill> bills = new ArrayList<>();
////		bills.add(new Bill(1L,"Vidit Mathur", "BILL1001",1200.50,"PENDING",LocalDate.of(2026, 3, 20)));
////		bills.add(new Bill(2L,"Amit Sharma","BILL1002",850.00,"PAID",LocalDate.of(2026, 3, 15)));
////		
//		return billService.getAllBills();
//	}
	
	@GetMapping
	public ResponseEntity<List<BillResponseDto>> getAllBills(){
		return ResponseEntity.ok(billService.getAllBills());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillResponseDto> getBillById(@PathVariable Long id) {
		return ResponseEntity.ok(billService.getBillById(id));
	}

	
//	@PostMapping
//	public BillResponseDto createBill(@Valid @RequestBody BillingRequestDto dto) {
//		//System.out.println("New Bill Received  " +bill);
//		//return billService.createBill(bill);
//		return billService.saveBill(dto);
//	}
	

	@PostMapping
	public ResponseEntity<BillResponseDto> createBill(@Valid @RequestBody BillingRequestDto dto){
	
		BillResponseDto createdBill = billService.createBill(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBill);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<BillResponseDto> updateBill(@PathVariable Long id,@Valid @RequestBody BillingRequestDto dto){
		BillResponseDto updatedBill = billService.updateBill(id, dto);
//		if(updatedBill != null) {
//	       return ResponseEntity.ok(updatedBill);		
//		}
		return ResponseEntity.ok(updatedBill);
	}
	
		
	@GetMapping("/status/{statusId}")
	public ResponseEntity<List<BillResponseDto>> getBillsByStatusId(@PathVariable Long statusId){
		return ResponseEntity.ok(billService.getBillsByStatusId(statusId));
	} 
	
	
	
//	@GetMapping("/consumer/{consumerName}")
//	public List<BillResponseDto> getBillByConsumerName(@PathVariable String consumerName){
//		return billService.getBillByConsumerName(consumerName);
//	}
//	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable Long id){
		boolean deleted = billService.deleteBill(id);
		
		if(deleted) {
		
			return ResponseEntity.ok("Bill deleted successfully");
		}
	
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
}
