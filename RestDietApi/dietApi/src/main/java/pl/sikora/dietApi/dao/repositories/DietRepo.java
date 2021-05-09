package pl.sikora.dietApi.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sikora.dietApi.dao.entities.Diet;

public interface DietRepo extends CrudRepository<Diet, Integer> {
}
