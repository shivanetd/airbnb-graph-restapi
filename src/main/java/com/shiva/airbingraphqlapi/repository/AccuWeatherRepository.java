package com.shiva.airbingraphqlapi.repository;

import retrofit2.*;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

import com.shiva.airbingraphqlapi.service.weather.model.LocationResponse;
import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;


public interface AccuWeatherRepository {

    @GET("locations/v1/cities/geoposition/search")
    Call<LocationResponse> getLocationKey(@Query("apikey") String apiKey, @Query("q") String latLong);
 
    
    @GET("currentconditions/v1/{locationKey}")
    Call<List<WeatherResponse>> getCurrentWeatherCondition(@Path("locationKey") String key, @Query("apikey") String apiKey);
}