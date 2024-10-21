package com.test.coffee.service.repositories;

import com.test.coffee.entity.CoffeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeTypeRepository extends JpaRepository<CoffeeType, Long> {
    CoffeeType findByType(String type);
}