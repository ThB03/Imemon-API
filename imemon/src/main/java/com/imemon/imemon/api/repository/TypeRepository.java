package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findById(long id);
}
