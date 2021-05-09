package pl.sikora.dietApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sikora.dietApi.dao.repositories.DietCaloriesRepo;
import pl.sikora.dietApi.dao.entities.DietCalories;

import java.util.Optional;

@Service
public class DietCaloriesService {

    private DietCaloriesRepo dietCaloriesRepo;

    @Autowired
    public DietCaloriesService(DietCaloriesRepo dietCaloriesRepo) {
        this.dietCaloriesRepo = dietCaloriesRepo;
    }

    public Optional<DietCalories> findById(Integer id){
        return dietCaloriesRepo.findById(id);
    }

    public Iterable<DietCalories> findAll(){
        return dietCaloriesRepo.findAll();
    }

    public DietCalories save(DietCalories dietCalories){
        return dietCaloriesRepo.save(dietCalories);
    }

}
