package fontys.jpaqueries.dto.dataMapper;

import fontys.jpaqueries.dto.MeasurementDto;
import fontys.jpaqueries.model.Measurement;
import org.springframework.web.bind.annotation.Mapping;


public interface IMeasurementMapper {

        MeasurementDto toDto( Measurement measurement);
        Measurement toEntity( MeasurementDto measurementDto);

}
