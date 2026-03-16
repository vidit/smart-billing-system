package com.vidit.billing.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vidit.billing.entity.Bill;
import com.vidit.billing.service.BillService;

@RestController
public class BillController {

    @Autowired
	private BillService billService;
	
	@GetMapping("/bills")
	public List<Bill> getAllBils(){
		
//		List<Bill> bills = new ArrayList<>();
//		bills.add(new Bill(1L,"Vidit Mathur", "BILL1001",1200.50,"PENDING",LocalDate.of(2026, 3, 20)));
//		bills.add(new Bill(2L,"Amit Sharma","BILL1002",850.00,"PAID",LocalDate.of(2026, 3, 15)));
//		
		return billService.getAllBils();
		
	}
	
	@PostMapping("/bills")
	public Bill createBill(@RequestBody Bill bill) {
		//System.out.println("New Bill Received  " +bill);
		return billService.createBill(bill);
	}
	
}
