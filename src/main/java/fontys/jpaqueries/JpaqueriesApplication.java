package fontys.jpaqueries;

import fontys.jpaqueries.mapper.MeasurementMapper;
import fontys.jpaqueries.mapper.MeasurementMappertest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication (scanBasePackages={"fontys.jpaqueries"})
@ComponentScan(basePackages ={"fontys.jpaqueries.controller","fontys.jpaqueries.service","fontys.jpaqueries.model","fontys.jpaqueries.repository","fontys.jpaqueries.mapper"})

public class JpaqueriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaqueriesApplication.class, args);
    }

    @Bean
   public MeasurementMapper measurementMapper() {
        return new MeasurementMapper();
    }

    @Bean
    public MeasurementMappertest measurementMappertest() {
        return new MeasurementMappertest();
    }
}
