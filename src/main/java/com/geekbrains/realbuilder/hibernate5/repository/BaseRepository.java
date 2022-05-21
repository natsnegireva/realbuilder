package com.geekbrains.realbuilder.hibernate5.repository;

import java.util.List;

public interface BaseRepository <T, ID> {
    T findById(ID id);
    List<T> findAll();
    void merge(T entity);
    boolean delete(T entity);
    boolean deleteById(ID id);
}