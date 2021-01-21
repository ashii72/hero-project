package com.example.hero.service;

import com.example.hero.model.Hero;

import java.util.List;

public interface HeroService {
    Hero getHeroByName(String name);
    List<Hero> getHeroByStrength(int strength);
    List<Hero> getHeroByStamina(int stamina);
    List<Hero> getHeroHealth();
    String getGodName();
}
