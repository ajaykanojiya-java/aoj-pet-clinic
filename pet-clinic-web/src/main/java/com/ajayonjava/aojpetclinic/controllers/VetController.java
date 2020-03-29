package com.ajayonjava.aojpetclinic.controllers;

import com.ajayonjava.aojpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String listIndex(Model model){
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
