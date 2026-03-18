package com.vidit.billing.entity;

import java.time.LocalDate;

public class Bill {

	private Long id;
	private String consumerName;
	private String billNumber;
	private Double amount;
	private String status;
	private LocalDate dueDate;
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Long id, String consumerName, String billNumber, Double amount, String status, LocalDate dueDate) {
		super();
		this.id = id;
		this.consumerName = consumerName;
		this.billNumber = billNumber;
		this.amount = amount;
		this.status = status;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumerName=" + consumerName + ", billNumber=" + billNumber + ", amount=" + amount
				+ ", status=" + status + ", dueDate=" + dueDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
