package com.imemon.imemon.api.repository;

import com.imemon.imemon.api.model.LoggedUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggedUsersRepository extends JpaRepository<LoggedUsers, Long> {
    LoggedUsers findBySession(String sessionId);
    Boolean existsBySession(String sessionId);
    void deleteBySession(String sessionId);
}
