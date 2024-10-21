package com.test.coffee.service;

import com.test.coffee.entity.CoffeeBag;
import com.test.coffee.entity.dto.RemainDto;
import com.test.coffee.service.repositories.ProductRepository;
import com.test.coffee.service.interfaces.CoffeeService;
import com.test.coffee.service.repositories.CoffeeBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeBagRepository coffeeBagRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public BigDecimal getLoseByTeam(Long teamNum) {
        BigDecimal result = productRepository.findAvgLoseByTeam(teamNum);
        if (result == null){
            result = BigDecimal.ZERO;
        }
        return result.setScale(0, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal getLoseTotal() {
        BigDecimal result = productRepository.findTotalAvgLose();
        if (result == null){
            result = BigDecimal.ZERO;
        }
        return result.setScale(0, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal getLoseByCountry(String country) {
        BigDecimal result = productRepository.findAvgLoseByCountry(country);
        if (result == null){
            result = BigDecimal.ZERO;
        }
        return result.setScale(0, RoundingMode.DOWN);
    }

    @Override
    public BigDecimal getLoseByCountryAndTeam(String country, Long teamNum) {
        BigDecimal result = productRepository.findAvgLoseByCountryAndTeam(country, teamNum);
        if (result == null){
            result = BigDecimal.ZERO;
        }
        return result.setScale(0, RoundingMode.DOWN);
    }

    @Override
    public RemainDto getRemains(List<String> countries, List<String> types) {
        RemainDto remainDto = new RemainDto();
        Map<String, BigDecimal> countryRemain = new HashMap<>();
        Map<String, BigDecimal> typeRemain = new HashMap<>();

        if (!countries.isEmpty()){
            for (String country: countries) {
                countryRemain.put(country, coffeeBagRepository.findRemainByCountry(country));
            }
        }

        if (!types.isEmpty()){
            for (String type: types) {
                typeRemain.put(type, coffeeBagRepository.findRemainByType(type));
            }
        }

        remainDto.setCountryRemain(countryRemain);
        remainDto.setTypeRemain(typeRemain);

        return remainDto;
    }

    @Override
    public void handleBag(Long bagNumber, BigDecimal weightInWork){
        CoffeeBag coffeeBag = coffeeBagRepository.findByBagNumber(bagNumber);
        coffeeBag.setCurrentWeight(coffeeBag.getCurrentWeight().subtract(weightInWork));
        coffeeBagRepository.save(coffeeBag);
    }
}
