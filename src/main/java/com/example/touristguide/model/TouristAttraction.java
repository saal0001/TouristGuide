package com.example.touristguide.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String by;
    private List<String> tags;


    public TouristAttraction (String name,String describtion,String by,List tags){
        this.description = describtion;
        this.name = name;
        this.by=by;
        this.tags=tags;

    }
    public TouristAttraction (){
    }

    public String getBy() {
        return by;
    }

    public List getTags() {
        return tags;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
