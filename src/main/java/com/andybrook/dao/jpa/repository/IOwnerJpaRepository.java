package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerJpaRepository extends JpaRepository<OwnerEntity, Long> {
}
