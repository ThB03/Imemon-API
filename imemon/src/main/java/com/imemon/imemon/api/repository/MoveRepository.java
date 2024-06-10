package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {
    Move findById(long id);
}
