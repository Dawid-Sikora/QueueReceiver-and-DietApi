package pl.sikora.dietApi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import pl.sikora.dietApi.dao.entities.Diet;
import pl.sikora.dietApi.dao.entities.DietCalories;
import pl.sikora.dietApi.dao.entities.DietOption;
import pl.sikora.dietApi.exception.diet.DietNotFoundException;
import pl.sikora.dietApi.services.DietCaloriesService;
import pl.sikora.dietApi.services.DietOptionService;
import pl.sikora.dietApi.services.DietService;

@RestController
public class DietApi {

    private DietCaloriesService dietCaloriesService;
    private DietService dietService;
    private DietOptionService dietOptionService;

    @Autowired
    public DietApi(DietCaloriesService dietCaloriesService, DietService dietService, DietOptionService dietOptionService) {
        this.dietCaloriesService = dietCaloriesService;
        this.dietService = dietService;
        this.dietOptionService = dietOptionService;
    }

    @GetMapping("/getAllDiets")
    public Iterable<Diet> getAllDiets() {
        return dietService.findAll();
    }


    @PostMapping("/addDiet")
    public Diet saveDiet(@RequestBody Diet diet){
        return dietService.save(diet);
    }

    @GetMapping("/getDiet")
    public Diet findDietByID(@RequestParam Integer id){
        return dietService.findById(id).orElseThrow(() -> new DietNotFoundException(id));
    }

    @PutMapping("/updateDiet")
    public Diet updateDiet(@RequestBody Diet diet){
        Diet dietToEdit = dietService.findById(diet.getDietId()).orElseThrow(()->new DietNotFoundException(diet.getDietId()));
        return dietService.save(diet);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

        Diet wege = new Diet(0, "wege", "Brak miesa", null);
        Diet miesna = new Diet(0, "miesna", "duzo miesa", null);
        Diet boalkowa = new Diet(0, "bialkowa", "duzo bialka", null);

        wege = dietService.save(wege);
        miesna = dietService.save(miesna);
        boalkowa = dietService.save(boalkowa);

        DietOption option1 = new DietOption(0, "name1", "abbreviation1", wege, null);
        DietOption option2 = new DietOption(0, "name2", "abbreviation2", miesna, null);

        option1 = dietOptionService.save(option1);
        option2 = dietOptionService.save(option2);
//
        DietCalories dietCalories1 = new DietCalories(0, 1000, option1);
        DietCalories dietCalories2 = new DietCalories(0, 1000, option2);
//
        dietCalories1 = dietCaloriesService.save(dietCalories1);
        dietCalories2 = dietCaloriesService.save(dietCalories2);

    }


}
