package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> touristAttractions=new ArrayList<>(List.of(
            new TouristAttraction("SMK","museum for kunst","København",List.of("Kunst","Museum")),
            new TouristAttraction("Odense Zoo","Europas bedste zoo","Odense",List.of("Børnevenligt")),
            new TouristAttraction("Dyrehaven","Naturpark med skovområder","Kongens Lyngby",List.of("Natur,","Gratis")),
            new TouristAttraction("Tivoli","Forlystelsespark i Københavns centrum","København",List.of("Børnevenligt"))
    ));

    public TouristRepository() {
    }



public List<String>getAttractionByTags(String name){
        for (TouristAttraction touristAttraction: touristAttractions){
            if (touristAttraction.getName().equalsIgnoreCase(name)){
                return touristAttraction.getTags();
            }
        }
        return Collections.emptyList();
    }


    public TouristAttraction createAttraction(TouristAttraction touristAttraction) {
        if (touristAttractions.add(touristAttraction)) {
            return touristAttraction;
        }
        return null;
    }

    public List<TouristAttraction> getAttractions() {
        return touristAttractions;
    }

    public TouristAttraction editAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction findTouristattraction : touristAttractions) {
            if (findTouristattraction.getName().equals(touristAttraction.getName())) {
                findTouristattraction.setDescription(touristAttraction.getDescription());
                findTouristattraction.setBy(touristAttraction.getBy());
                findTouristattraction.setTags(touristAttraction.getTags());
            }
        }
        return touristAttraction;
    }


    public TouristAttraction deleteAttraction(String name) {
        TouristAttraction touristAttractionMain = null;
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                touristAttractionMain = touristAttraction;
                break;
            }

        }
        touristAttractions.remove(touristAttractionMain);
        return touristAttractionMain;
    }


    public TouristAttraction getAttractionByName(String name) {
        TouristAttraction found=null;
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                found= attraction;
            }
        }
        return found;
    }

    public TouristAttraction searchAttractions(String name){
        TouristAttraction found = null;
        for (TouristAttraction touristAttractions: touristAttractions){
            if (touristAttractions.getName().equalsIgnoreCase(name)){
                found = touristAttractions;
            }
            if (found != null){
                return found;
            }
        }
        return found;
    }
    public List<String> getCities(){
        List<String> cities = new ArrayList<>();
        for (TouristAttraction touristAttraction:touristAttractions){
            cities.add(touristAttraction.getBy());
        }
        return cities;
    }

    public List<String> allTags(){
        List<String> tags= new ArrayList<>();
        tags.add("Gratis");
        tags.add("Børnevenligt");
        tags.add("Kunst");
        tags.add("Museum");
        tags.add("Natur");
        tags.add("Sjov");
        return tags;
    }

    public List<String> getTags(){
        List<String> returnTags = new ArrayList<>();
        for (String tags:allTags()){
           returnTags.add(tags);
        }
        return returnTags;
    }




}
