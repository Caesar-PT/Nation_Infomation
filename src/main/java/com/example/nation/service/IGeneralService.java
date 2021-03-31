package com.example.nation.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T save(T t);
    T findById(long id);
    T update(T t);
    boolean remove(long id);
    List<T> findAllByName(String name);
}
