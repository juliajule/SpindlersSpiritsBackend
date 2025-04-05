package com.example.WhiskyApp.DTO;

public class WhiskyRequest {

    private String name;
    private String distillery;
    private Integer age;
    private Double alcoholPercentage;
    private String description;
    private String imageUrl;
    private Long tastingId;

    public WhiskyRequest() {}

    public String getName() {
        return name;
    }

    public String getDistillery() {
        return distillery;
    }

    public Integer getAge() {
        return age;
    }

    public Double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getTastingId() {
        return tastingId;
    }
}
