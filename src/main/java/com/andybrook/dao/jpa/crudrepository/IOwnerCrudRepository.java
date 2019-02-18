package com.andybrook.dao.jpa.crudrepository;

import com.andybrook.dao.jpa.entity.customer.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerCrudRepository extends CrudRepository<OwnerEntity, Long> {
}
