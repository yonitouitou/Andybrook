package com.andybrook.dao.owner;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnerJpaRepository extends JpaRepository<OwnerEntity, Long> {
}
