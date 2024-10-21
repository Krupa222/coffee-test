package com.test.coffee.service.interfaces;

import com.test.coffee.entity.dto.RemainDto;

import java.math.BigDecimal;
import java.util.List;

public interface CoffeeService {
    BigDecimal getLoseByTeam(Long teamNum);
    BigDecimal getLoseTotal();
    BigDecimal getLoseByCountry(String country);
    BigDecimal getLoseByCountryAndTeam(String country, Long teamNum);
    RemainDto getRemains(List<String> country, List<String> type);

    void handleBag(Long bagNumber, BigDecimal weightInWork);
}
