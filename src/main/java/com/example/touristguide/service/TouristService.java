package com.example.touristguide.service;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class TouristService {
    TouristRepository touristRepository;
    public TouristService(TouristRepository touristRepository){
        this.touristRepository= touristRepository;
    }


    public TouristAttraction creatAttraction(TouristAttraction touristAttraction){
        return touristRepository.createAttraction(touristAttraction);

    }

    public List<TouristAttraction> getAttacrions(){
        return touristRepository.getAttractions();
    }

    public TouristAttraction editAttractions(TouristAttraction touristAttraction){
        return touristRepository.editAttraction(touristAttraction);
    }

    public TouristAttraction deleteAttraction(String name){
        return touristRepository.deleteAttraction(name);
    }

    public TouristAttraction getAttractionByName(String name){
        return touristRepository.getAttractionByName(name);
    }

    public TouristAttraction searchAttractions(String name){
        return touristRepository.searchAttractions(name);
    }
    public List<String> getAttractionByTags(String name){
        return touristRepository.getAttractionByTags(name);
    }

    public List<String> getTags(){
        return touristRepository.getTags();
    }
    public List<String> getCities(){
        return touristRepository.getCities();
    }

}
