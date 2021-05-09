package pl.sikora.dietApi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sikora.dietApi.dao.entities.DietOption;
import pl.sikora.dietApi.exception.diet.DietNotFoundException;
import pl.sikora.dietApi.exception.dietOptions.DietOptionNotFoundException;
import pl.sikora.dietApi.services.DietOptionService;

@RestController
public class DietOptionApi {

    private DietOptionService dietOptionService;

    @Autowired
    public DietOptionApi(DietOptionService dietOptionService) {
        this.dietOptionService = dietOptionService;
    }

    @GetMapping("/getAllDietsOptions")
    public Iterable<DietOption> getAllDiets() {
        return dietOptionService.findAll();
    }


    @PostMapping("/addDietOption")
    public DietOption saveDietOption(@RequestBody DietOption dietOption){
        return dietOptionService.save(dietOption);
    }

    @GetMapping("/getDietOption")
    public DietOption findDietOptrionByID(@RequestParam Integer id){
        return dietOptionService.findById(id).orElseThrow(() -> new DietOptionNotFoundException(id));
    }

    @PutMapping("/updateDietOption")
    public DietOption updateDietOptrion(@RequestBody DietOption dietOption){
        DietOption dietToEdit = dietOptionService.findById(dietOption.getDietOptionId()).orElseThrow(()->new DietNotFoundException(dietOption.getDietOptionId()));
        return dietOptionService.save(dietOption);
    }

}
