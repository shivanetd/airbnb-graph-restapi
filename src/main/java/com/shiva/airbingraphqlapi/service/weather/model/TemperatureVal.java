package com.shiva.airbingraphqlapi.service.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureVal {
    private Float Value;
    private String Unit;
    private Integer UnitType;
}
