package com.shiva.airbingraphqlapi.service.weather.impl;

import java.io.IOException;
import java.util.List;

import javax.swing.text.html.Option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shiva.airbingraphqlapi.repository.AccuWeatherRepository;
import com.shiva.airbingraphqlapi.service.weather.WeatherService;
import com.shiva.airbingraphqlapi.service.weather.model.LocationResponse;
import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

import java.util.Optional;
import retrofit2.Response;


@Service
public class AccuWeatherServiceImpl implements WeatherService {

    @Value("${accu.weather.apikey}")
    private String apiKey;

    Logger logger = LoggerFactory.getLogger(AccuWeatherServiceImpl.class);
  
    private final AccuWeatherRepository accWeatherRepository;

    public AccuWeatherServiceImpl(AccuWeatherRepository accuWeatherRepository){
        this.accWeatherRepository = accuWeatherRepository;
    }

    @Override
    public Optional<WeatherResponse> getCurrentWeatherByLatLong(String lat, String longitude){
        Optional<WeatherResponse> res = null;
        try{
            Response<LocationResponse> locationResponse = accWeatherRepository.getLocationKey(apiKey, lat).execute();

            if(!locationResponse.isSuccessful()){
                logger.error("failed fetching location key from accuweather");
                return res;
            }
            

            Response<List<WeatherResponse>> waResponse = accWeatherRepository.getCurrentWeatherCondition(locationResponse.body().getKey(), apiKey).execute();

            if(!waResponse.isSuccessful())
                logger.error("failed fetching current condition from accuweather");

            return waResponse.body().stream().findFirst();
        }catch(IOException exception){
            logger.error("Exception during fetch, message:- {}", exception.getMessage(), exception);
        }
        
        return res;
    }
  
}
