package com.starlove.starlove.controller;

import com.starlove.starlove.entity.Profil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import com.starlove.starlove.repository.ProfilRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/home")
    public String backHome() {

        return "/home";
    }

    private ProfilRepository repository = new ProfilRepository();

    @GetMapping("/profilrandom")
    public  String profilRandom(Model model){

        List<Profil> profils = repository.profilRandom();
        model.addAttribute("profils", profils);

        return "profil";
    }

    @PostMapping("/profil")
    public String postProfil(Model model,
                             @RequestParam(defaultValue = "%") String colors,
                             @RequestParam(defaultValue = "%") String genderValue,
                             @RequestParam(defaultValue = "%") String planetName
    ) {
        List<Profil> profils = repository.findLove(genderValue, colors, planetName);

        model.addAttribute("profils", repository.findLove(genderValue, colors, planetName));

        if (profils.size() > 0) {
            return "profil";

        }
        return "try-again";
    }
}



