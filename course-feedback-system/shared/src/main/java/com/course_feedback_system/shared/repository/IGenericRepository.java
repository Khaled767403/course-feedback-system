package com.course_feedback_system.shared.repository;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T> {
    Optional<T> findById(Long id);

    List<T> findAll();

    default T save(T entity) {
        throw new UnsupportedOperationException("Save method not implemented");
    }

    default void deleteById(Long id) {
        throw new UnsupportedOperationException("Delete method not implemented");
    }
}
