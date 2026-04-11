package com.vidit.billing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill_statuses")
public class BillStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "status_name", nullable = false, unique = true ,length = 50)
	private String statusName;

	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "is_active" , nullable = false)
	private Boolean isActive = true;

	public BillStatus() {
		super();
	}

	public BillStatus(Long statusId, String statusName, String description, Boolean isActive) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.description = description;
		this.isActive = isActive;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
