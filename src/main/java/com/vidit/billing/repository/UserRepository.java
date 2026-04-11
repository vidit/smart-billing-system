package com.vidit.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vidit.billing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}



