package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
   List<Team> findAllByUsername(String username);
   Team findById(long id);
}
