package com.example.superherodatabasev5.controllers;

import com.example.superherodatabasev5.model.Superhero;
import com.example.superherodatabasev5.repositories.ISuperheroRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/superhero")
public class SuperheroController {
    ISuperheroRepository iSuperheroRepository;

    public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        iSuperheroRepository = (ISuperheroRepository) context.getBean(impl);
    }

    @GetMapping(path = "/all")
    public String getAllSuperheroes(Model model) {
        List<Superhero> heroList = iSuperheroRepository.getSuperheroAll();
        model.addAttribute("heroList", heroList);
        return "index";
    }


}
