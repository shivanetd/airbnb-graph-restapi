package com.shiva.airbingraphqlapi.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Weather {
    public String weatherText;
    public float temperature;
    public String unit;
}
