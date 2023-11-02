package com.shiva.airbingraphqlapi.service.weather.model;

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
    }
