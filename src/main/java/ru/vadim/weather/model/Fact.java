package ru.vadim.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Fact {
    Long temp;
    Long feels_like;
    String condition;
    Long wind_speed;
    Long pressure_mm;
    Long humidity;


    public String getCondition() {
        String newCondition ="";
        if(condition.contains("-")) {
            newCondition = condition.replace("-","_");
            return newCondition;
        } else return condition;
    }

    public Long getTemp() {
        return temp;
    }

    public void setTemp(Long temp) {
        this.temp = temp;
    }

    public Long getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Long feels_like) {
        this.feels_like = feels_like;
    }

    public Long getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Long wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Long getPressure_mm() {
        return pressure_mm;
    }

    public void setPressure_mm(Long pressure_mm) {
        this.pressure_mm = pressure_mm;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
