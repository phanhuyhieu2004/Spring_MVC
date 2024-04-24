package com.example.youtube2.service;

import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E>findAll();
    E save(E e);
    void remove(Long id);
    Optional<E>findById(Long id);
}
