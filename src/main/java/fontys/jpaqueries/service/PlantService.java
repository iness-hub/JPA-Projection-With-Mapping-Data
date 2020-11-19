package fontys.jpaqueries.service;


import fontys.jpaqueries.model.Measurement;
import fontys.jpaqueries.model.Plant;
import fontys.jpaqueries.repository.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    private PlantRepo plantRepo;

    public void save(Plant plant) {
        plantRepo.save(plant);
    }

    public Plant get(Date date){
        return null;//measurementRepo.get();
    }

       public List<Plant> findAll(){
        return (List<Plant>) plantRepo.findAll();
    }
}
