package com.example.WhiskyApp.dto;

import com.example.WhiskyApp.config.FlexibleLocalDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WhiskySearchRequest {

    private String query;

    private Integer minAge;
    private Integer maxAge;

    private Double minAlcoholPercentage;
    private Double maxAlcoholPercentage;

    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    @JsonDeserialize(using = FlexibleLocalDateDeserializer.class)
    private LocalDate tastingDateFrom;

    @JsonDeserialize(using = FlexibleLocalDateDeserializer.class)
    private LocalDate tastingDateTo;

    public WhiskySearchRequest() {}

    public String getQuery() {
        return query;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public Double getMinAlcoholPercentage() {
        return minAlcoholPercentage;
    }

    public Double getMaxAlcoholPercentage() {
        return maxAlcoholPercentage;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public LocalDate getTastingDateFrom() {
        return tastingDateFrom;
    }

    public LocalDate getTastingDateTo() {
        return tastingDateTo;
    }
}
