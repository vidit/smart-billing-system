package com.vidit.billing.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vidit.billing.entity.Bill;

@Service
public class BillService {
	
	private final List<Bill> bills = new ArrayList();
	private Long nextId = 1L;
	
	public List<Bill> getAllBlls(){
		return bills;
	}
	
  public Bill saveBill(Bill bill) {
	  bill.setId(nextId++);
      bills.add(bill);
      return bill;
  }
	
  
  public Bill updateBill(Long id, Bill updatedBill) {
	  Optional<Bill> existingBillOptional = bills.stream()
			  .filter(b -> b.getId().equals(id))
			  .findFirst();
	  
	  if(existingBillOptional.isPresent()) {
		  Bill existingBill = existingBillOptional.get();
		  
		  existingBill.setBillNumber(updatedBill.getBillNumber());
		  existingBill.setConsumerName(updatedBill.getConsumerName());
		  existingBill.setAmount(updatedBill.getAmount());
		  existingBill.setDueDate(updatedBill.getDueDate());
		  existingBill.setStatus(updatedBill.getStatus());
	  
		  return existingBill;
	  
	  }

	  
	  return null;  
  }
	

  
  public boolean deleteBill(Long id) {
	  return bills.removeIf(b -> b.getId().equals(id));
  }
  
  
	public List<Bill> getAllBils(){
		
		List<Bill> bills = new ArrayList<>();
		bills.add(new Bill(1L, "Vidit Mathur", "BILL1001", 1200.50, "PENDING", LocalDate.of(2026, 03, 20)));
	    bills.add(new Bill(2L, "Amit Sharma", "BILL1002", 825.50, "PAID", LocalDate.of(2026, 02, 25)));
		
	    return bills;
	}
//	
//
//	public Bill createBill(Bill bill) {
//		System.out.println("New Bill Received " +bill);
//		return bill;
//	}
	
	
}
