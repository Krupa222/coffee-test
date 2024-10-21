package com.test.coffee.service.repositories;

import com.test.coffee.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}