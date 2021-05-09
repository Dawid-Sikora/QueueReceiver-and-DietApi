package pl.sikora.dietApi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sikora.dietApi.dao.repositories.DietRepo;
import pl.sikora.dietApi.dao.entities.Diet;

import java.util.Optional;

@Service
public class DietService {

    private DietRepo dietRepo;

    @Autowired
    public DietService(DietRepo dietRepo) {
        this.dietRepo = dietRepo;
    }

    public Optional<Diet> findById(Integer id){
        return dietRepo.findById(id);
    }

    public Iterable<Diet> findAll(){
        return dietRepo.findAll();
    }

    public Diet save(Diet diet){
        return dietRepo.save(diet);
    }




}

