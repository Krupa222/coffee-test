package com.test.coffee.service.repositories;

import com.test.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("select avg(p.losePercent) from product p where p.team.number = :teamNumber")
  BigDecimal findAvgLoseByTeam(@Param("teamNumber") Long teamNumber);

  @Query("select avg(p.losePercent) from product p where p.country.name = :country")
  BigDecimal findAvgLoseByCountry(@Param("country") String country);

  @Query("select avg(p.losePercent) from product p where p.country.name = :country and p.team.number = :teamNumber")
  BigDecimal findAvgLoseByCountryAndTeam(@Param("country") String country, @Param("teamNumber") Long teamNumber);

  @Query("select avg(p.losePercent) from product p")
  BigDecimal findTotalAvgLose();
}