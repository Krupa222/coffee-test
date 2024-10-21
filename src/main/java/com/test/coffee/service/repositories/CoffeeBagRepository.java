package com.test.coffee.service.repositories;

import com.test.coffee.entity.CoffeeBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CoffeeBagRepository extends JpaRepository<CoffeeBag, Long> {

    @Query("select sum(p.currentWeight) from coffeeBag p where p.country.name = :country")
    BigDecimal findRemainByCountry(@Param("country") String country);

    @Query("select sum(p.currentWeight) from coffeeBag p where p.type.type = :type")
    BigDecimal findRemainByType(@Param("type") String type);

    CoffeeBag findByBagNumber(Long bagNumber);
}