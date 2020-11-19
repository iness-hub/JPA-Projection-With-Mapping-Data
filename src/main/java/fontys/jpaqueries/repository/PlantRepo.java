package fontys.jpaqueries.repository;

import fontys.jpaqueries.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepo extends CrudRepository<Plant, Integer> {
}
