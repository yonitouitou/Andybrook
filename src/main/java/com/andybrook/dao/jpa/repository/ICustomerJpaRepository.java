package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
