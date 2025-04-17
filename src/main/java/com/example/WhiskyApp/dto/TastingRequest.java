package com.example.WhiskyApp.dto;

import java.util.Date;

public class TastingRequest {

    private String name;
    private Date date;
    private String imageUrl;
    private String description;

    public TastingRequest() {}

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
