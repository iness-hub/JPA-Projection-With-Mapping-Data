package fontys.jpaqueries.mapper;


import fontys.jpaqueries.repository.MeasurementSummary;
import fontys.jpaqueries.response.MeasurementInfo;

import java.util.*;

public class MeasurementMapper implements GMapper<List<MeasurementSummary>, List<MeasurementInfo>>{

    @Override
    public List<MeasurementInfo> map(List<MeasurementSummary> measurementSummaryList) {
        Map<Date, MeasurementInfo> data = new HashMap<>();
        for(MeasurementSummary measurement : measurementSummaryList) {
            MeasurementInfo info;
            if(!data.containsKey(measurement.getDate())) {
                info = new MeasurementInfo();
                info.setDate(measurement.getDate());
                data.put(measurement.getDate(),info);

            } else {
                info = data.get(measurement.getDate());
                }
                switch (measurement.getType().toUpperCase()) {
                    case "HUMIDITY":
                        info.setAverageMoisture(measurement.getValue());
                        break;
                    case "TEMPERATURE":
                        info.setAverageTemp(measurement.getValue());
                        break;
                }

        }
        return new ArrayList<>(data.values());
    }


}
