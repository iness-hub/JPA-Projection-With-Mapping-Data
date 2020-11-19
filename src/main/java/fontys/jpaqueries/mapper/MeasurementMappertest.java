package fontys.jpaqueries.mapper;
import fontys.jpaqueries.model.Measurement;
import fontys.jpaqueries.repository.MeasurementSummary;
import fontys.jpaqueries.responseTest.MeasurementInfoTest;

import java.util.*;

public class MeasurementMappertest implements GMapper<List<MeasurementSummary>, List<MeasurementInfoTest>>{

    @Override
    public List<MeasurementInfoTest> map(List<MeasurementSummary> MeasurementSummaryList) {
        Map<Date, MeasurementInfoTest> data = new HashMap<>();
        for(MeasurementSummary measurement : MeasurementSummaryList) {
            MeasurementInfoTest info;
            if(!data.containsKey(measurement.getDate())) {
                info = new MeasurementInfoTest();
                info.setDate(measurement.getDate());
                data.put(measurement.getDate(),info);

            } else {
                info = data.get(measurement.getDate());
            }
            info.setType(measurement.getType());
            info.setValue(measurement.getValue());
        }
        return new ArrayList<>(data.values());
    }
}
