package com.example.WhiskyApp.dto;

public class WhiskyUpdateRequest {
    private String name;
    private String distillery;
    private Integer age;
    private Double alcoholPercentage;
    private String description;
    private String imageUrl;
    private Long tastingId;

    public WhiskyUpdateRequest() {}

    public WhiskyUpdateRequest(String name, String distillery, Integer age, Double alcoholPercentage, String description, String imageUrl, Long tastingId) {
        this.name = name;
        this.distillery = distillery;
        this.age = age;
        this.alcoholPercentage = alcoholPercentage;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tastingId = tastingId;
    }

    public String getName() { return name; }
    public String getDistillery() { return distillery; }
    public Integer getAge() { return age; }
    public Double getAlcoholPercentage() { return alcoholPercentage; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public Long getTastingId() { return tastingId; }
}
