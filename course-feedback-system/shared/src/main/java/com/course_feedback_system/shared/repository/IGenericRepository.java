package com.course_feedback_system.shared.repository;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository <T>{
    Optional<T> findById(Long id);
    List<T> findAll();
    T save(T entity);
    void deleteById(Long id);
}
