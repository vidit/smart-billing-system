package com.vidit.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.billing.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

	List<Bill> findByStatusStatusId(Long statusId);

	List<Bill> findByConsumerNameContainingIgnoreCase(String consumerName);
}
