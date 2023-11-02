package com.shiva.airbingraphqlapi.service.weather;

import java.io.IOException;
import java.util.Optional;

import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

public interface WeatherService {

    Optional<WeatherResponse> getCurrentWeatherByLatLong(String latLong);
} 
