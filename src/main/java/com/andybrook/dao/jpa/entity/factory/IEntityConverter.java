package com.andybrook.dao.jpa.entity.factory;

public interface IEntityConverter<T, U> {

    T toModel(U entity);

    U toEntity(T model);
}
