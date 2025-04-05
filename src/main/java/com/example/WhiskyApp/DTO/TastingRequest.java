package com.example.WhiskyApp.DTO;

import java.util.Date;

public class TastingRequest {

    private String name;
    private Date date;
    private String imageUrl;

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
}
