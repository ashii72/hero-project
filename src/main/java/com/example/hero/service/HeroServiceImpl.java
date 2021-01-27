package com.example.hero.service;

import com.example.hero.dto.HeroHealthDto;
import com.example.hero.model.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {

    GodService godService;

    public HeroServiceImpl(GodService godService) {
        this.godService = godService;
    }

    Hero h1 = new Hero("Athena", 85, 73, 76);
    Hero h2 = new Hero("Gaia", 88, 89, 98);
    Hero h3 = new Hero("Atreus", 95, 65, 98);

    List<Hero> heroList = List.of(h1, h2, h3);

    //List<Hero> heroList2 = new ArrayList<Hero>();

    List<Hero> heroList2 = List.of(h1, h2, h3);

    List<Hero> heroList3 = List.of(h1, h2, h3);

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

        List<Hero> selectedList = new ArrayList<>();

        for (Hero hero : heroList3) {
            if (hero.getStrength() == strength) {
                selectedList.add(hero);
            }
        }
        return selectedList;
    }

    @Override
    public List<Hero> getHeroByStamina(int stamina) {

        List<Hero> staminaList = new ArrayList<>();

        for (Hero hero : heroList2) {
            if (hero.getStamina() == stamina) {
                staminaList.add(hero);
            }
        }
        return staminaList;
    }

    @Override
    public List<HeroHealthDto> getHeroHealth() {

        List<HeroHealthDto> healthList = new ArrayList<>();

        for (Hero hero : heroList) {
            //HeroHealthDto heroHealthDto = new HeroHealthDto(hero.getName(),hero.getHealth());
            healthList.add(new HeroHealthDto(hero.getName(), hero.getHealth()));
        }
        return healthList;
    }

    @Override
    public String getGodName() {
        return godService.getGodName();
    }

    @Override
    public List<Hero> getSortedListByStrengthAsc() {

        List<Hero> strengthListAsc = new ArrayList<>();

        strengthListAsc.add(h1);
        strengthListAsc.add(h2);
        strengthListAsc.add(h3);

        //strengthListAsc.stream().sorted();

        //strengthListAsc.sort(Comparator.naturalOrder())

        //Collections.sort(strengthListAsc);

        return strengthListAsc;
    }

    @Override
    public List<Hero> getSortedListByStrengthDesc() {

        List<Hero> strengthListDesc = new ArrayList<>();

        strengthListDesc.add(h1);
        strengthListDesc.add(h2);
        strengthListDesc.add(h3);

        // strengthListDesc.stream().sorted(Comparator.reverseOrder());

        // strengthListDesc.sort(strengthListDesc,Collections.reverseOrder());

        // strengthListDesc.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return strengthListDesc;
    }

    @Override
    public Hero findHeroByHeroObject(Hero hero) {
        // return null; // Impl using contain,...

        List<Hero> findHeroByObject = heroList2;

        if (findHeroByObject.contains(h2)) {
            return h2;
        }
        return (Hero) findHeroByObject;
    }

    @Override
    public Hero removeHeroByHeroObject(Hero hero) {

        List<Hero> removeHeroByObject = heroList3;

        removeHeroByObject.remove(h1);
        return (Hero) removeHeroByObject;
    }
}
