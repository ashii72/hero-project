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

//    Hero h1 = new Hero("Athena", 20, 70, 76);
//    Hero h2 = new Hero("Gaia", 15, 40, 56);
//    Hero h3 = new Hero("Atreus", 45, 85, 95);

    Hero h1 = new Hero("Athena", 20, 70, 76);
    Hero h2 = new Hero("Gaia", 32, 70, 95);
    Hero h3 = new Hero("Atreus", 45, 85, 95);

    List<Hero> heroList = List.of(h1, h2, h3);

    //List<Hero> heroList2 = new ArrayList<Hero>();

    List<Hero> heroList2 = new ArrayList<>();

    List<Hero> heroList3 = List.of(h1, h2, h3);

    Comparator<Hero> compareByHealthAndStamina = Comparator.comparing(Hero :: getHealth).thenComparing(Hero :: getStamina);

    List<Hero> heroList4 = heroList3.stream().sorted(compareByHealthAndStamina).collect(Collectors.toList());

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

        Hero h4 = new Hero("Ashkan",90,100,98);

        heroList2.add(h1);
        heroList2.add(h2);
        heroList2.add(h3);
        heroList2.add(h4);

        Collections.sort(heroList2);
        return heroList2;



//        heroList2.sort(Comparator.naturalOrder());
//        return heroList2;

        //strengthListAsc.stream().sorted();

        //strengthListAsc.sort(Comparator.naturalOrder());


    }

    @Override
    public List<Hero> getSortedListByStrengthDesc() {

        heroList2.add(h1);
        heroList2.add(h2);
        heroList2.add(h3);

        Collections.sort(heroList2,Collections.reverseOrder());
        return heroList2;

//        heroList2.sort(Comparator.reverseOrder());
//        return heroList2;

        // strengthListDesc.stream().sorted(Comparator.reverseOrder());

        // strengthListDesc.sort(strengthListDesc,Collections.reverseOrder());

        // strengthListDesc.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


    }

    @Override
    public Hero findHeroByHeroObject(Hero hero) {
        // return null; // Impl using contain,...

            if (heroList2.contains(hero)) {
                return hero;
            } else {
                return null;
            }
    }

    @Override
    public List<Hero> removeHeroByHeroObject(Hero hero) {

        //TODO //use equal method & contain

        heroList2.add(h1);
        heroList2.add(h2);
        heroList2.add(h3);

        List<Hero> selectedList1 = new ArrayList<>();

        for (Hero hero1: heroList2) {
            if (!hero1.name.equals(hero.name)) {
                selectedList1.add(hero1);
            }
        }

        //int index = heroList2.indexOf(hero);
        //heroList2.remove(hero);
        return selectedList1;
        //return heroList2.subList(1,2);
        //return heroList2;

    }

    @Override
    public List<Hero> multipleSorting() {

        return heroList4;
    }
}
