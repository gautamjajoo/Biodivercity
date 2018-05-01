package com.example.sridhar123.biodiversity;

import java.io.Serializable;

public class NewPost implements Serializable {

    public String imageUrl;
    public String location;
    public String description;
    public String species;

    public NewPost(String imageUrl, String location, String description, String species) {
        this.imageUrl = imageUrl;
        this.location = location;
        this.description =description;
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public String getSpecies() {
        return species;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
