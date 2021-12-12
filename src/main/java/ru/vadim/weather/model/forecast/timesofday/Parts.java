package ru.vadim.weather.model.forecast.timesofday;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Parts {
    @JsonProperty("night")
    private Night night;
    @JsonProperty("morning")
    private Morning morning;
    @JsonProperty("day")
    private Day day;
    @JsonProperty("evening")
    private Evening evening;
}
