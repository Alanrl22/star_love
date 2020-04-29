package com.starlove.starlove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.starlove.starlove.repository.ProfilRepository;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home() {

        return "home";
    }

    private ProfilRepository repository = new ProfilRepository();

    @PostMapping("/profil")
    public String postProfil(Model model,
                             @RequestParam String gender,
                             @RequestParam String planet,
                             @RequestParam String eye_color
    ) {
        //model.addAttribute("profil", repository.save(gender, planet, eye_color));

        return "profil";


    }
}
