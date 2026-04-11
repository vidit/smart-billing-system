package com.vidit.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.billing.entity.BillStatus;

public interface BillStatusRepository extends JpaRepository<BillStatus, Long>{

}
