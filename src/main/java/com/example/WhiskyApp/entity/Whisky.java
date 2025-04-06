package com.example.WhiskyApp.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "whiskys")
public class Whisky {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String distillery;
    private Integer age;
    private Double alcoholPercentage;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "tasting_id", nullable = false)
    @JsonBackReference
    private Tasting tasting;

    public Whisky() {}

    public Whisky(String distillery, String name, Integer age, Double alcoholPercentage, String description, String imageUrl, Tasting tasting) {
        this.distillery = distillery;
        this.name = name;
        this.age = age;
        this.alcoholPercentage = alcoholPercentage;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tasting = tasting;
    }

    public Long getId() {
        return id;
    }

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

    public Tasting getTasting() {
        return tasting;
    }
}
