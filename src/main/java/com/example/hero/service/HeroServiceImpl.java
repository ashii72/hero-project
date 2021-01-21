package com.example.hero.service;

import com.example.hero.model.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HeroServiceImpl implements HeroService {

    GodService godService;

    public HeroServiceImpl(GodService godService) {
        this.godService = godService;
    }

    Hero h1 = new Hero("Athena",85,100,76);
    Hero h2 = new Hero("Gaia",88,100,98);
    Hero h3 = new Hero("Atreus",95,100,98);

    List<Hero> heroList = List.of(h1,h2,h3);

    List<String> testList = new ArrayList<String>();

    List<Hero> heroList2 = new ArrayList<Hero>();

    @Override
    public Hero getHeroByName(String name) {

        //Hero selectedHero = new Hero("ashkan",100,100,100);
        //AtomicReference<Hero> selectedHero = new AtomicReference<>(h3);
        //Hero selectedHero = h1;

//          heroList.forEach(hero -> {
//              if (hero.getName().equals(name)) {
//               selectedHero.set(hero);
//           }
//          });

//        for (Hero hero:heroList) {
//           if (hero.getName().equals(name)) {
//               selectedHero = hero;
//           }
//        }

//        for (int i = 0; i < heroList.size(); i++) {
//            if (heroList.get(i).getName().equals(name)) {
//                selectedHero = heroList.get(i);
//            }
//        }


       //heroList.forEach(hero -> hero.na);

        //heroList2.add(h1);
       // heroList2.add(h2);
        //heroList2.add(h3);

//        switch (name) {
//            case "Athena":
//                return h1;
//            case "Gaia":
//                return h2;
//            case "Atreus":
//                return h3;
//            default:
//                // return "No Hero Selected"
//                break;
//        }
        //return selectedHero;
        return heroList.stream().filter(hero -> hero.getName().equals(name)).findFirst().orElse(h1);
    }

    @Override
    public List<Hero> getHeroByStrength(int strength) {
        return null;
    }

    @Override
    public List<Hero> getHeroByStamina(int stamina) {
        return null;
    }

    @Override
    public List<Hero> getHeroHealth() {
        return null;
    }

    @Override
    public String getGodName() {
        return godService.getGodName();
    }
}
