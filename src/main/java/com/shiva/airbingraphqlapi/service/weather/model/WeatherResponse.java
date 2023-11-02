package com.shiva.airbingraphqlapi.service.weather.model;

import com.shiva.airbingraphqlapi.model.Weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private String LocalObservationDateTime;
    private Integer EpochTime;
    private String WeatherText;
    private Integer WeatherIcon;
    private Boolean HasPrecipitation;
    private Object PrecipitationType;
    private Boolean IsDayTime;
    private Temperature Temperature;
    private String MobileLink;
    private String Link;

    public Weather toWeather(){
        Weather weather = new Weather();
        weather.weatherText = this.WeatherText;
        weather.temperature = this.Temperature.getImperial().getValue();
        weather.unit = this.Temperature.getImperial().getUnit();
        return weather;
    }
}
