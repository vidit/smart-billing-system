package com.vidit.billing.mapper;

import com.vidit.billing.dto.BillResponseDto;
import com.vidit.billing.dto.BillingRequestDto;
import com.vidit.billing.entity.Bill;

public final class BillMapper {

	private BillMapper() {
	}

	public static Bill toEntity(BillingRequestDto dto) {

		Bill bill = new Bill();
		bill.setBillNumber(dto.getBillNumber());
		bill.setConsumerName(dto.getConsumerName());
		bill.setDueDate(dto.getDueDate());
		bill.setAmount(dto.getAmount());
		return bill;
	}

	public static BillResponseDto toResponseDto(Bill bill) {
	
		BillResponseDto responseDto = new BillResponseDto();
		responseDto.setId(bill.getId());
		responseDto.setBillNumber(bill.getBillNumber());
		responseDto.setConsumerName(bill.getConsumerName());
		responseDto.setAmount(bill.getAmount());
		responseDto.setDueDate(bill.getDueDate());
		
		
		if (bill.getUser() != null) {
			responseDto.setUserId(bill.getUser().getUserId());
			responseDto.setUserName(bill.getUser().getFullName());
		}
		
       if (bill.getCategory() != null) {
    	   responseDto.setCategoryId(bill.getCategory().getCategoryId());
    	   responseDto.setCategoryName(bill.getCategory().getCategoryName());
       }	
		
       if (bill.getStatus() != null) {
    	   responseDto.setStatusId(bill.getStatus().getStatusId());
    	   responseDto.setStatusName(bill.getStatus().getStatusName());
       }
       
       return responseDto;
       
	}

	public static void updateEntity(Bill bill, BillingRequestDto dto) {

		bill.setBillNumber(dto.getBillNumber());
		bill.setConsumerName(dto.getConsumerName());
		bill.setAmount(dto.getAmount());
		bill.setDueDate(dto.getDueDate());
		

	}

}
