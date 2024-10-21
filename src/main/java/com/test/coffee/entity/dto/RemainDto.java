package com.test.coffee.entity.dto;

import com.test.coffee.entity.CoffeeType;
import com.test.coffee.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemainDto {

    private Map<String, BigDecimal> countryRemain;
    private Map<String, BigDecimal> typeRemain;

}
