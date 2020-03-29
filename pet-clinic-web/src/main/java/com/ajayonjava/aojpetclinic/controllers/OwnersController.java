package com.ajayonjava.aojpetclinic.controllers;

import com.ajayonjava.aojpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getOwnersList(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }
}
