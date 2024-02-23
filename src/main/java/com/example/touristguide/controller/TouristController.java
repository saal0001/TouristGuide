package com.example.touristguide.controller;

import com.example.touristguide.model.TouristAttraction;
import com.example.touristguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }


    @GetMapping("")
    public String attractions(Model model) {
        model.addAttribute("attractions", touristService.getAttacrions());
        return "attractionList";
    }

    @GetMapping("/add")
    public String addAttraction(Model model) {
        model.addAttribute("attraction",new TouristAttraction());
        model.addAttribute("cities",touristService.getCities());
        model.addAttribute("getTags",touristService.getTags());

        return "tilføj";
    }

    @PostMapping("/save")
    public String addedAttraction(@RequestBody TouristAttraction touristAttraction, Model model) {
       model.addAttribute("save",touristService.creatAttraction(touristAttraction));
       return "attractionList";
    }


    @GetMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        return new ResponseEntity<>(touristService.deleteAttraction(name), HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<TouristAttraction> editAttraction(@RequestBody TouristAttraction touristAttraction) {
        return new ResponseEntity<>(touristService.editAttractions(touristAttraction), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<TouristAttraction> byName(@PathVariable String name) {
        return new ResponseEntity<>(touristService.getAttractionByName(name), HttpStatus.OK);
    }


    @GetMapping("{name}/tags")
    public String attractionTags(@PathVariable String name, Model model) {
        model.addAttribute("tags",touristService.getAttractionByTags(name));
        model.addAttribute("attractions", touristService.getAttacrions());
        model.addAttribute("name", name);
        return "tags";
    }


}
