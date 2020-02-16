package com.andybrook.dao;

public interface IEntityConverter<Dto, Entity> {

    Entity toEntity(Dto object);

    Dto fromEntity(Entity entity);
}
