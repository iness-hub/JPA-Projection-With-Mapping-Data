package fontys.jpaqueries.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fontys.jpaqueries.mapper.MeasurementMapper;
import fontys.jpaqueries.mapper.MeasurementMappertest;
import fontys.jpaqueries.model.Measurement;
import fontys.jpaqueries.repository.MeasurementRepo;
import fontys.jpaqueries.repository.MeasurementSummary;
import fontys.jpaqueries.response.MeasurementInfo;
import fontys.jpaqueries.response.MeasurementResponse;
import fontys.jpaqueries.responseTest.MeasurementInfoTest;
import fontys.jpaqueries.responseTest.MeasurementReponseTest;
import fontys.jpaqueries.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RestController
@EnableAutoConfiguration
@RequestMapping("/druppel")

public class MeasurementController {
    @Autowired
    private MeasurementService measurementService;
    @Autowired
    private MeasurementMapper measurementMapper;
    @Autowired
    private MeasurementMappertest measurementMapperTest;



    @GetMapping(path="/all")
    public @ResponseBody Iterable findAll() {
        return measurementService.findAll();
    }

    @GetMapping(path="/averageFromListJpaProjection")
    public @ResponseBody List<MeasurementSummary> getAverageTest2(){
        return measurementService.getAverageSummaryTest();
    }


    @GetMapping(path="/averagetest1")
    public MeasurementResponse getAverageTest(){
        int code =200;
        String message ="ok";
        String temperatureUnit="metric";
        MeasurementResponse response=new MeasurementResponse(code,message,temperatureUnit);
        List<MeasurementInfo> data = new ArrayList<>();
        List<MeasurementSummary> infoList = measurementService.getAverageSummaryTest();

        response.setData(measurementMapper.map(infoList));

        return response;
    }


    @GetMapping(path="/averagetest2")
    public MeasurementReponseTest getAverageTest4(){
        int code =200;
        String message ="ok";
        String temperatureUnit="metric";
        MeasurementReponseTest response=new MeasurementReponseTest(code,message,temperatureUnit);

        List<MeasurementSummary> list = measurementService.getAverageSummaryTest();

        Map<Date,List<Map<String,Object>>> summary = new HashMap<>();
        for(MeasurementSummary measurementSummary : list) {
            ObjectMapper m = new ObjectMapper();
            Map<String,Object> measurementMap= m.convertValue(measurementSummary, Map.class);
            measurementMap.remove("date");
            if(summary.containsKey(measurementSummary.getDate())) {
                List<Map<String, Object>> listSummary = summary.get(measurementSummary.getDate());
                listSummary.add(measurementMap);
            }
            else {
                List<Map<String,Object>> listSummary = new ArrayList<>();
                listSummary.add(measurementMap);
                summary.put(measurementSummary.getDate(),listSummary);

            }
        }
        response.setData(summary);
        return response;
    }



}
