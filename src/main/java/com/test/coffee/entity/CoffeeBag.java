package com.test.coffee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "coffeeBag")
@Table(name = "coffee_bag")
public class CoffeeBag {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "weight_id")
    private BagWeight weight;

    @Column(name = "current_weight", nullable = false)
    private BigDecimal currentWeight;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CoffeeType type;

    @Column(name = "arabica_percentage", nullable = false)
    private int arabicaPercentage;

    @Column(name = "robusta_percentage", nullable = false)
    private int robustaPercentage;
}