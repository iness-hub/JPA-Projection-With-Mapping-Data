package fontys.jpaqueries.repository;

import fontys.jpaqueries.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Integer> {

    @Query("Select avg (value) From Measurement Where date >= ?1 and date<=?2" )
    public Float averageMoisture (Date date1, Date date2);

  @Query("Select date,type, avg (value) AS value From Measurement Where date >= ?1 and date<=?2 group by type,date" )
  public List<Measurement>getAverageList(Date date1,Date date2);

  @Query("Select date As date,type As type, avg (value) AS value From Measurement group by type,date" )
  public List<MeasurementSummary>getAverageSummary();



}
