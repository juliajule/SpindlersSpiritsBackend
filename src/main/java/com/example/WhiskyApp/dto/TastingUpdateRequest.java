package com.example.WhiskyApp.dto;

import java.util.Date;

public class TastingUpdateRequest {

    private String name;
    private Date date;
    private String imageUrl;
    private String description;

    public TastingUpdateRequest() {}

    public TastingUpdateRequest(String name, Date date, String imageUrl, String description) {
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getName() { return name; }
    public Date getDate() { return date; }
    public String getImageUrl() { return imageUrl; }
    public String getDescription() { return description; }
}
