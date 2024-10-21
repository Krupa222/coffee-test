package com.test.coffee.service.repositories;

import com.test.coffee.entity.BagWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagWeightRepository extends JpaRepository<BagWeight, Long> {
}