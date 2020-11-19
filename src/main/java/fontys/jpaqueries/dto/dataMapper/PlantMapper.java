package fontys.jpaqueries.dto.dataMapper;

import fontys.jpaqueries.dto.PlantDto;
import fontys.jpaqueries.model.Plant;

public class PlantMapper {
    PlantDto toDto(Plant plant){
        PlantDto plantDto= new PlantDto();
        return plantDto;
    };
    Plant toEntity(PlantDto plantDto){
        Plant plant = new Plant();
        return plant;
    };
}
