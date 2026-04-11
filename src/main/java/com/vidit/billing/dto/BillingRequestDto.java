package com.vidit.billing.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BillingRequestDto {

	@NotBlank(message = "Bill Number is required")
	@Size(min =3, max=20, message = "Bill Number must be 3 and 20 characters")
	private String billNumber;
	
	@NotBlank(message = "Biller Name is required")
	private String consumerName;

	@NotNull(message = "Amount is required")
	@DecimalMin(value = "1.0",inclusive = true, message = "Amount must be greater then 0" )
	private BigDecimal amount;
	
	@NotNull(message = "Due Date is Required")
	@FutureOrPresent(message = "Due Date Must Be Today Or Future")
	private LocalDate dueDate;

	@NotNull(message = "User Id is Required")
	private Long userId;
	
	@NotNull(message = "Category is Required")
	private Long categoryId;
	
    @NotNull(message = "Status Id is Requried")	
	private Long statusId;

	
	public BillingRequestDto() {
		super();
	}


	public BillingRequestDto(String billNumber, String consumerName, BigDecimal amount, LocalDate dueDate, Long userId,
			Long categoryId, Long statusId) {
		super();
		this.billNumber = billNumber;
		this.consumerName = consumerName;
		this.amount = amount;
		this.dueDate = dueDate;
		this.userId = userId;
		this.categoryId = categoryId;
		this.statusId = statusId;
	}


	public String getBillNumber() {
		return billNumber;
	}


	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}


	public String getConsumerName() {
		return consumerName;
	}


	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public Long getStatusId() {
		return statusId;
	}


	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}


	
	
	
	
	
	
	
	
	
}
