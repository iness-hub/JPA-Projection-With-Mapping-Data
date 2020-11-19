package fontys.jpaqueries.dto.dataMapper;


import fontys.jpaqueries.dto.PlantDto;
import fontys.jpaqueries.model.Plant;

public interface IPlantMapper {
    PlantDto toDto(Plant plant);
    Plant toEntity(PlantDto plantDto);
}
