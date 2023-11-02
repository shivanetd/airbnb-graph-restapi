package com.shiva.airbingraphqlapi.service.weather;

import java.util.List;

import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

public interface WeatherService {

    List<WeatherResponse> getCurrentWeatherByLatLong(String latLong);
} 
