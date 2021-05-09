package pl.sikora.dietApi.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sikora.dietApi.dao.entities.DietOption;

public interface DietOptionRepo extends CrudRepository<DietOption,Integer> {
}
