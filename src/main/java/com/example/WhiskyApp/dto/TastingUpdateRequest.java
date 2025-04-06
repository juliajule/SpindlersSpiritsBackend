package com.example.WhiskyApp.dto;

import java.util.Date;

public class TastingUpdateRequest {

    private String name;
    private Date date;
    private String imageUrl;

    public TastingUpdateRequest() {}

    public TastingUpdateRequest(String name, Date date, String imageUrl) {
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
    }

    public String getName() { return name; }
    public Date getDate() { return date; }
    public String getImageUrl() { return imageUrl; }
}
