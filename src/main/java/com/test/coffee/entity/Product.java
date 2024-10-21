package com.test.coffee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType type;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "coffee_bag_id")
    private CoffeeBag coffeeBag;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "weight_in", nullable = false)
    private BigDecimal weightIn;

    @Column(name = "weight_Out", nullable = false)
    private BigDecimal weightOut;

    @Column(name = "lose_Percent", nullable = false)
    private BigDecimal losePercent;

    public void calcLosePercent(){
        losePercent = weightOut.divide(weightIn, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100L)).setScale(2, RoundingMode.DOWN);
    }

}