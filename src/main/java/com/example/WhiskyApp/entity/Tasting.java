package com.example.WhiskyApp.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tastings")
public class Tasting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @Column
    private String description;

    @OneToMany(mappedBy = "tasting", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Whisky> whiskys;

    public Tasting() {}

    public Tasting(String name, Date date, String imageUrl, String description, List<Whisky> whiskys) {
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
        this.whiskys = whiskys;
    }

    public Tasting(String name, Date date, String imageUrl, String description) {
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {return description;}

    public List<Whisky> getWhiskys() {
        return whiskys;
    }
}