package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Move;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository {
    Move findById(long id);
}
