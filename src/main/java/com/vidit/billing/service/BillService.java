package com.vidit.billing.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vidit.billing.entity.Bill;

@Service
public class BillService {

	public List<Bill> getAllBils(){
		
		List<Bill> bills = new ArrayList<>();
		bills.add(new Bill(1L, "Vidit Mathur", "BILL1001", 1200.50, "PENDING", LocalDate.of(2026, 03, 20)));
	    bills.add(new Bill(2L, "Amit Sharma", "BILL1002", 825.50, "PAID", LocalDate.of(2026, 02, 25)));
		
	    return bills;
	}
	

	public Bill createBill(Bill bill) {
		System.out.println("New Bill Received " +bill);
		return bill;
	}
	
	
}
