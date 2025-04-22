package com.example.WhiskyApp.dto;

import java.math.BigDecimal;

public class WhiskyUpdateRequest {
    private String name;
    private String distillery;
    private Integer age;
    private Double alcoholPercentage;
    private BigDecimal price;
    private BigDecimal liter;
    private String link;
    private BigDecimal uvp;
    private String description;
    private String imageUrl;
    private Long tastingId;

    public WhiskyUpdateRequest() {}

    public WhiskyUpdateRequest(String name, String distillery, Integer age, Double alcoholPercentage, BigDecimal price, BigDecimal liter, String link, BigDecimal uvp, String description, String imageUrl, Long tastingId) {
        this.name = name;
        this.distillery = distillery;
        this.age = age;
        this.alcoholPercentage = alcoholPercentage;
        this.price = price;
        this.liter = liter;
        this.link = link;
        this.uvp = uvp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tastingId = tastingId;
    }

    public String getName() { return name; }
    public String getDistillery() { return distillery; }
    public Integer getAge() { return age; }
    public Double getAlcoholPercentage() { return alcoholPercentage; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getLiter() {return liter;}
    public String getLink() {return link;}
    public BigDecimal getUvp() {return uvp;}
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public Long getTastingId() { return tastingId; }

}