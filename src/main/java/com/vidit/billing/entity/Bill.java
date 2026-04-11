package com.vidit.billing.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Customer Name is Required")
	private String consumerName;
	@NotBlank(message = "Bill Number is Required")
	private String billNumber;
	@NotNull(message = "Amount is Required")
	@Positive(message = "Amount Must Be Greater Then Zero")
	private BigDecimal amount;

	@NotNull(message = "Due Date is Requried")
	@FutureOrPresent(message = "Due Date Must Be Today or Future")
	private LocalDate dueDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private BillCategory category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private BillStatus status;

	@Column(name = "generated_date")
	private LocalDate generatedDate;

	public Bill() {
		super();
	}

	public Bill(Long id, String consumerName, String billNumber, BigDecimal amount, LocalDate dueDate, User user,
			BillCategory category, BillStatus status, LocalDate generatedDate) {
		super();
		this.id = id;
		this.consumerName = consumerName;
		this.billNumber = billNumber;
		this.amount = amount;
		this.dueDate = dueDate;
		this.user = user;
		this.category = category;
		this.status = status;
		this.generatedDate = generatedDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BillCategory getCategory() {
		return category;
	}

	public void setCategory(BillCategory category) {
		this.category = category;
	}

	public BillStatus getStatus() {
		return status;
	}

	public void setStatus(BillStatus status) {
		this.status = status;
	}

	public LocalDate getGeneratedDate() {
		return generatedDate;
	}

	public void setGeneratedDate(LocalDate generatedDate) {
		this.generatedDate = generatedDate;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumerName=" + consumerName + ", billNumber=" + billNumber + ", amount=" + amount
				+ ", dueDate=" + dueDate + ", user=" + user + ", category=" + category + ", status=" + status
				+ ", generatedDate=" + generatedDate + "]";
	}

	
	
	
	
}
