package com.shiva.airbingraphqlapi.service.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private String localObservationDateTime;
    private Integer epochTime;
    private String weatherText;
    private Integer weatherIcon;
    private Boolean hasPrecipitation;
    private Object precipitationType;
    private Boolean isDayTime;
    private Temperature temperature;
    private String mobileLink;
    private String link;
    }
