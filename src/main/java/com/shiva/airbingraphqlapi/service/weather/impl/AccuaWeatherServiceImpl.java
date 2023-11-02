package com.shiva.airbingraphqlapi.service.weather.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shiva.airbingraphqlapi.repository.AccuWeatherRepository;
import com.shiva.airbingraphqlapi.service.weather.WeatherService;
import com.shiva.airbingraphqlapi.service.weather.model.LocationResponse;
import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

import retrofit2.Response;


@Service
public class AccuaWeatherServiceImpl implements WeatherService {

    @Value("${accu.weather.apikey}")
    private String apiKey;
  
    private final AccuWeatherRepository accuWeatherRepository;

    public AccuaWeatherServiceImpl(AccuWeatherRepository accuWeatherRepository){
        this.accuWeatherRepository = accuWeatherRepository;
    }

    public WeatherResponse getCurrentWeatherByLatLong(String latLong) throws IOException{

        Response<LocationResponse> locationResponse = accuWeatherRepository.getLocationKey(apiKey, latLong).execute();

        if(!locationResponse.isSuccessful())
            throw new IOException();
        

        Response<WeatherResponse> waResponse = accuWeatherRepository.getCurrentWeatherCondition(locationResponse.body().getKey(), apiKey).execute();

        if(!waResponse.isSuccessful())
            throw new IOException();

        return waResponse.body();

        
    }
  
}
