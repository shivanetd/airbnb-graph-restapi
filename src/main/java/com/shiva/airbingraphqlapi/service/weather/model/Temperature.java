package com.shiva.airbingraphqlapi.service.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temperature {
    private TemperatureVal metric;
    private TemperatureVal imperial;
}
