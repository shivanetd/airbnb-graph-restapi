package com.shiva.airbingraphqlapi.service.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureVal {
    private Float value;
    private String unit;
    private Integer unitType;
}
