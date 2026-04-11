package com.vidit.billing.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillResponseDto {

	private Long id;
	private String billNumber;
	private String consumerName;
	private BigDecimal amount;
	private LocalDate dueDate;
	
	private Long userId;
	private String userName;
	
	private Long categoryId;
	private String categoryName;
	private Long statusId;
	private String statusName;
	
	public BillResponseDto() {
		super();
	}

	public BillResponseDto(Long id, String billNumber, String consumerName, BigDecimal amount, LocalDate dueDate,
			Long userId, String userName, Long categoryId, String categoryName, Long statusId, String statusName) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.consumerName = consumerName;
		this.amount = amount;
		this.dueDate = dueDate;
		this.userId = userId;
		this.userName = userName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	
	



}
