package com.test.coffee.controller;

import com.test.coffee.entity.dto.RemainDto;
import com.test.coffee.service.interfaces.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Tag(name="Coffee Controller", description="Получение статистики по обжаренному кофе")
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @Operation(
            summary = "Потери бригады",
            description = "Потери бригады"
    )
    @GetMapping("/getLoseByTeam")
    public BigDecimal getLoseByTeam(@RequestParam Long teamNum){
        return coffeeService.getLoseByTeam(teamNum);
    }

    @Operation(
            summary = "Потери по стране",
            description = "Потери по стране"
    )
    @GetMapping("/getLoseByCountry")
    public BigDecimal getLoseByCountry(@RequestParam String country){
        return coffeeService.getLoseByCountry(country);
    }

    @Operation(
            summary = "Потери бригады по стране",
            description = "Потери бригады по стране"
    )
    @GetMapping("/getLoseByCountryAndTeam")
    public BigDecimal getLoseByCountryAndTeam(@RequestParam String country,
                                              @RequestParam  Long teamNum){
        return coffeeService.getLoseByCountryAndTeam(country, teamNum);
    }

    @Operation(
            summary = "Общие потери",
            description = "Общие потери"
    )
    @GetMapping("/getLoseTotal")
    public BigDecimal getLoseTotal(){
        return coffeeService.getLoseTotal();
    }

    @Operation(
            summary = "Остатки по странам и сортам",
            description = "Остатки по странам и сортам"
    )
    @GetMapping("/getRemains")
    public RemainDto getRemains(@RequestParam List<String> countries,
                                @RequestParam List<String> types){
        return coffeeService.getRemains(countries, types);
    }

}
