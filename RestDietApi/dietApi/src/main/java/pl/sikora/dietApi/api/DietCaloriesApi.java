package pl.sikora.dietApi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sikora.dietApi.dao.entities.DietCalories;
import pl.sikora.dietApi.exception.diet.DietNotFoundException;
import pl.sikora.dietApi.exception.dietCalories.DietCaloriesNotFoundException;
import pl.sikora.dietApi.services.DietCaloriesService;

@RestController
public class DietCaloriesApi {

    private DietCaloriesService dietCaloriesService;

    @Autowired
    public DietCaloriesApi(DietCaloriesService dietOptionService) {
        this.dietCaloriesService = dietOptionService;
    }


    @GetMapping("/getAllDietsCalories")
    public Iterable<DietCalories> getAllDietsCalories() {
        return dietCaloriesService.findAll();
    }


    @PostMapping("/addDietCalories")
    public DietCalories saveDietCalories(@RequestBody DietCalories dietCalories){
        return dietCaloriesService.save(dietCalories);
    }

    @GetMapping("/getDietCalories")
    public DietCalories findDietCaloriesByID(@RequestParam Integer id){
        return dietCaloriesService.findById(id).orElseThrow(() -> new DietCaloriesNotFoundException(id));
    }

    @PutMapping("/updateDietCalories")
    public DietCalories updateDietCalories(@RequestBody DietCalories dietCalories){
        DietCalories dietCaloriesToEdit = dietCaloriesService.findById(dietCalories.getDietCaloriesId()).orElseThrow(()->new DietNotFoundException(dietCalories.getDietCaloriesId()));
        return dietCaloriesService.save(dietCalories);
    }

}
