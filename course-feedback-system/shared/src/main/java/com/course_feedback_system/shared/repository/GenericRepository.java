package com.course_feedback_system.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface GenericRepository<T> extends JpaRepository<T, Long> {

    default Optional<T> findById(Long id) {
        return findById(id);
    }

    default List<T> findAll() {
        return findAll();
    }

    default T saveEntity(T entity) {
        return save(entity);
    }

    default void deleteById(Long id) {
        deleteById(id);
    }
}
