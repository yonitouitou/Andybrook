package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}