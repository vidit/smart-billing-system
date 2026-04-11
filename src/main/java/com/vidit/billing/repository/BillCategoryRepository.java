package com.vidit.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.billing.entity.BillCategory;

public interface BillCategoryRepository  extends JpaRepository<BillCategory, Long>{

}
