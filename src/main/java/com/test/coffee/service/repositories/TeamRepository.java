package com.test.coffee.service.repositories;

import com.test.coffee.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    Team findByNumber(Long number);
}