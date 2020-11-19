package fontys.jpaqueries.dto.dataMapper;

import fontys.jpaqueries.dto.MeasurementDto;
import fontys.jpaqueries.model.Measurement;

public class MeasurementMapper {

    MeasurementDto toDto(Measurement measurement){
        MeasurementDto measurementDto=new MeasurementDto();
        measurementDto.setId(measurement.getId());
        measurementDto.setEspId(measurement.getEspId());
        measurementDto.setDate(measurement.getDate());
        measurementDto.setValue(measurement.getValue());
        return measurementDto;
    };
    Measurement toEntity( MeasurementDto measurementDto){
        Measurement measurement= new Measurement();
        measurement.setId(measurementDto.getId());
        measurement.setEspId(measurementDto.getEspId());
//        measurement.setType(measurementDto.getType());
        measurement.setValue(measurementDto.getValue());
        measurement.setDate(measurementDto.getDate());

        return measurement;
    };
}
