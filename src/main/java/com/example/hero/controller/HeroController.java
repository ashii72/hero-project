package com.example.hero.controller;

import com.example.hero.model.Hero;
import com.example.hero.service.GodServiceImpl;
import com.example.hero.service.HeroService;
import com.example.hero.service.HeroServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/godofwar")
public class HeroController {

    HeroService heroService = new HeroServiceImpl(new GodServiceImpl());

    @GetMapping("/hero")
    public Hero getHeroByName(@RequestParam("name") String name) {
        return heroService.getHeroByName(name);
    }

    @PostMapping("/find/hero")
    public Hero getHeroByHeroObject(@RequestBody Hero hero) {
        return heroService.findHeroByHeroObject(hero);
    }
}
