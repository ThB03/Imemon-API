package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findById(long id);
}
