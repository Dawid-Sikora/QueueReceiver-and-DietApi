package pl.sikora.dietApi.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sikora.dietApi.dao.entities.DietCalories;

public interface DietCaloriesRepo extends CrudRepository<DietCalories, Integer> {
}
