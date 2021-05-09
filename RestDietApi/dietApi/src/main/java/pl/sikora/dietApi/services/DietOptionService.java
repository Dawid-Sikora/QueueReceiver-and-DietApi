package pl.sikora.dietApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sikora.dietApi.dao.repositories.DietOptionRepo;
import pl.sikora.dietApi.dao.entities.DietOption;

import java.util.Optional;

@Service
public class DietOptionService {

    private DietOptionRepo dietOptionRepo;

    @Autowired
    public DietOptionService(DietOptionRepo dietOptionRepo) {
        this.dietOptionRepo = dietOptionRepo;
    }

    public Optional<DietOption> findById(Integer id){
        return dietOptionRepo.findById(id);
    }

    public Iterable<DietOption> findAll(){
        return dietOptionRepo.findAll();
    }

    public DietOption save(DietOption dietOption){
        return dietOptionRepo.save(dietOption);
    }


}
