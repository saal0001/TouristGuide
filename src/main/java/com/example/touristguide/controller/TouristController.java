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
        model.addAttribute("attraction", new TouristAttraction());
        model.addAttribute("cities", touristService.getCities());
        model.addAttribute("getTags", touristService.getTags());
        return "tilføj";
    }

    @PostMapping("/save")
    public String addedAttraction(@ModelAttribute TouristAttraction touristAttraction, Model model) {
        model.addAttribute("save", touristService.creatAttraction(touristAttraction));
        return "redirect:/attractions";
    }


    @GetMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable String name,Model model) {
        model.addAttribute("delete",touristService.deleteAttraction(name));
        return "redirect:/attractions";
    }




    @GetMapping("/{name}/edit")
    public String byName(@PathVariable String name, Model model) {
        model.addAttribute("attraction", touristService.getAttractionByName(name));
        model.addAttribute("cities", touristService.getCities());
        model.addAttribute("getTags", touristService.getTags());
        return "update";
    }

    @PostMapping("/update")
    public String editAttraction(@ModelAttribute TouristAttraction touristAttraction, Model model) {
        model.addAttribute("attraction",touristService.editAttractions(touristAttraction));
        return "redirect:/attractions";
    }

    @GetMapping("{name}/tags")
    public String attractionTags(@PathVariable String name, Model model) {
        model.addAttribute("tags", touristService.getAttractionByTags(name));
        model.addAttribute("attractions", touristService.getAttacrions());
        model.addAttribute("name", name);
        return "tags";
    }


}
