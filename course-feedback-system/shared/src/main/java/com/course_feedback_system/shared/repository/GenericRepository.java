package com.course_feedback_system.shared.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

    @Repository
    public class GenericRepository<T> implements IGenericRepository<T> {

        private final JpaRepository<T, Long> jpaRepository;

        @Autowired
        public GenericRepository(JpaRepository<T, Long> jpaRepository) {
            this.jpaRepository = jpaRepository;
        }

        @Override
        public Optional<T> findById(Long id) {
            return jpaRepository.findById(id);
        }

        @Override
        public List<T> findAll() {
            return jpaRepository.findAll();
        }

        @Override
        public T save(T entity) {
            return jpaRepository.save(entity);
        }

        @Override
        public void deleteById(Long id) {
            jpaRepository.deleteById(id);
        }
    }


