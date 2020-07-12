package com.coderapper.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID>
{
    List<T> findAll();
    Optional<T> findById(ID id);
    void save(T item);
    void update(T item);
    void delete(T item);
}
