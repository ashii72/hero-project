package com.example.hero.controller;

import com.example.hero.dto.HeroHealthDto;
import com.example.hero.model.Hero;
import com.example.hero.service.GodServiceImpl;
import com.example.hero.service.HeroService;
import com.example.hero.service.HeroServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/godofwar")
public class HeroController {

    HeroService heroService = new HeroServiceImpl(new GodServiceImpl()); // why we impl "new GodServiceImpl()" in HeroServiceImpl as a input?

    @GetMapping("/hero")
    public Hero getHeroByName(@RequestParam("name") String name) {
        return heroService.getHeroByName(name);
    }

    @GetMapping("/hero/strength")
    public List<Hero> getHeroByStrength(@RequestParam("strength") int strength) {
        return heroService.getHeroByStrength(strength);
    }

    @GetMapping("/hero/stamina/{stamina}")
    public List<Hero> getHeroByStamina(@PathVariable int stamina) {
        return heroService.getHeroByStamina(stamina);
    }

    @GetMapping("/hero/health")
    public List<HeroHealthDto> getHeroHealth() {
        return heroService.getHeroHealth();
    }

    @PostMapping("/find/hero")
    public Hero getHeroByHeroObject(@RequestBody Hero hero) {
        return heroService.findHeroByHeroObject(hero);
    }

    @PostMapping("/remove/hero")
    public Hero removeHeroByHeroObject(@RequestBody Hero hero) {
        return heroService.removeHeroByHeroObject(hero);
    }
}
