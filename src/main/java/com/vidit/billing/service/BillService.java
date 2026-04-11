package com.vidit.billing.service;

import java.util.List;

import com.vidit.billing.dto.BillResponseDto;
import com.vidit.billing.dto.BillingRequestDto;
import com.vidit.billing.entity.Bill;

public interface BillService {

	List<BillResponseDto> getAllBills();
	BillResponseDto getBillById(Long id);
	
	BillResponseDto createBill(BillingRequestDto bill);
	
	BillResponseDto updateBill(Long id, BillingRequestDto updatedBill);
	
	List<BillResponseDto> getBillsByStatusId(Long statusId);
	
	List<BillResponseDto> getBillByConsumerName(String consumerName);
	
	boolean deleteBill(Long id);

	
}
