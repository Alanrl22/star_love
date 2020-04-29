package com.starlove.starlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.starlove.starlove.repository.ProfilRepository;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {

        return "home";
    }

    private ProfilRepository repository = new ProfilRepository();

    @PostMapping("/profil")
    public String postProfil(Model model,
                             @RequestParam String colors,
                             @RequestParam String genderValue,
                             @RequestParam int planet_id
    ) {
        System.out.println(planet_id);
        model.addAttribute("profils", repository.findLove(genderValue, colors, planet_id));
      
        return "profil";
    }



}
