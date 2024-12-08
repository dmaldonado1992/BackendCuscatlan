package com.bd.pdv.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty(value="id", required=false)
    private String id;
    @JsonProperty(value="title", required=false)
    private String title;
    @JsonProperty(value="description", required=false)
    private String description;
    @JsonProperty(value="price", required=false)
    private Double price;
    @JsonProperty(value="category", required=false)
    private String category;
    @JsonProperty(value="image", required=false)
    private String image;


    @JsonProperty(value="Error", required=false)
    private boolean error;
    @JsonProperty(value="Message", required=false)
    private String message;

    public Product() {
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
