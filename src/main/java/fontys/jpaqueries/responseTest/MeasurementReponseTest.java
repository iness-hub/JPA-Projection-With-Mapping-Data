package fontys.jpaqueries.responseTest;

import fontys.jpaqueries.response.MeasurementInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MeasurementReponseTest {
    private int code;
    private String message;
    private String temperatureUnit;
    private Map<Date,List<Map<String,Object>>>data;


    public MeasurementReponseTest() {
    }

    public MeasurementReponseTest(int code, String message, String temperatureUnit) {
        this.code = code;
        this.message = message;
        this.temperatureUnit = temperatureUnit;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public Map<Date, List<Map<String, Object>>> getData() {
        return data;
    }

    public void setData(Map<Date, List<Map<String, Object>>> data) {
        this.data = data;
    }
}
