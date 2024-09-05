package com.example.MainProjectAll.controller;


import com.example.MainProjectAll.entity.Chef;
import com.example.MainProjectAll.services.ChefService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
public class ChefController {

    @Autowired
    private ChefService chefService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/chefs")
//    public List<Chef> listChefs(){
    public List<Chef> listChefs(@RequestParam(value = "cuisine", required = false) String cuisine, Model model) {
        List<Chef> chefs;
        if (cuisine != null && !cuisine.isEmpty()) {
            chefs = chefService.findByCuisine(cuisine);
        } else {
            chefs = chefService.findAll();
        }
        model.addAttribute("chefs", chefs);
        return chefs ;  
//    	return chefService.findAll();
    }

   

    @PostMapping("/chefs")
    public Chef saveChef(@ModelAttribute("chef") Chef chef) {
        chefService.save(chef);
        return chefService.save(chef);
    }

   

    @PostMapping("/chefs/{id}")
    public Chef updateChef(@PathVariable Long id, @ModelAttribute("chef") Chef chef) {
        chefService.save(chef);
        return chef;
    }

    @DeleteMapping("/chefs/delete/{id}")
    public String deleteChef(@PathVariable Long id) {
        chefService.deleteById(id);
        return "The id object is deleted";
    }
}
