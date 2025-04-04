package com.example.WhiskyApp.Entity;

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

    @OneToMany(mappedBy = "tasting", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Whisky> whiskys;

    public Tasting() {}

    public Tasting(Long id, String name, Date date, String imageUrl, List<Whisky> whiskys) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
        this.whiskys = whiskys;
    }

    // Getter und Setter

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

    public List<Whisky> getWhiskys() {
        return whiskys;
    }
}