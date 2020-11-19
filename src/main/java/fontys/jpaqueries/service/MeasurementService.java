package fontys.jpaqueries.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fontys.jpaqueries.model.Measurement;
import fontys.jpaqueries.repository.MeasurementRepo;
import fontys.jpaqueries.repository.MeasurementSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepo measurementRepo;

    public void save(Measurement measurement) {
        measurementRepo.save(measurement);
    }


    public Measurement get(Integer id){
        return measurementRepo.findById(id).get();
    }

   /* public List<IMeasurementAverage> averageTest(){
        return  measurementRepo.averageValueByTypeByDay();
    }*/
    public List<Measurement> findAll(){
        return (List<Measurement>) measurementRepo.findAll();
    }

    public  List<Measurement> getAverageTest(){
        try {
            Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse("02/06/2020");
            Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020");
            return measurementRepo.getAverageList(date1,date2);
        } catch( Exception e){
            return null;
        }
    }

    public  List<MeasurementSummary> getAverageSummaryTest(){

           return measurementRepo.getAverageSummary();

    }

    public Map<Date,List<Map<String,Object>>> getAverageSummaryGroupedByDay(int days, int EspId) {

            List<MeasurementSummary> list=null;
            list= measurementRepo.getAverageSummary();


        Map<Date, List<Map<String, Object>>> summary = new HashMap<>();
        for (MeasurementSummary measurementSummary : list) {
            ObjectMapper m = new ObjectMapper();
            Map<String, Object> measurementMap = m.convertValue(measurementSummary, Map.class);
            measurementMap.remove("date");
            if (summary.containsKey(measurementSummary.getDate())) {
                List<Map<String, Object>> listSummary = summary.get(measurementSummary.getDate());
                listSummary.add(measurementMap);
            } else {
                List<Map<String, Object>> listSummary = new ArrayList<>();
                listSummary.add(measurementMap);
                summary.put(measurementSummary.getDate(), listSummary);
            }
        }
        return summary;
    }



}
