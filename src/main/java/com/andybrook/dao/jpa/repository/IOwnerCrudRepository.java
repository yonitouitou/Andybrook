package com.andybrook.dao.jpa.repository;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerCrudRepository extends CrudRepository<OwnerEntity, Long> {
}
