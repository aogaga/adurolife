package com.aogaga.adurolife.utility;

import java.util.List;

public interface CrudService<T> {
    T create(T entity);
    T getById(Long Id);
    List<T> all();
    T update(T entity);
    void delete(Long Id);
}
