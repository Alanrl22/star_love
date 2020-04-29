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
                             /*
                             @RequestParam String planet,*/
                             @RequestParam String colors,
                             @RequestParam String genderValue
    ) {
        System.out.println(colors);
        model.addAttribute("profils", repository.findLove(genderValue, colors));

        return "profil";
    }



}
