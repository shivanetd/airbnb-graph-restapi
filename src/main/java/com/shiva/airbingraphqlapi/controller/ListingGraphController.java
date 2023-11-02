package com.shiva.airbingraphqlapi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;
import com.shiva.airbingraphqlapi.model.Location;
import com.shiva.airbingraphqlapi.model.Weather;
import com.shiva.airbingraphqlapi.repository.AirBnBListingRepository;
import com.shiva.airbingraphqlapi.service.weather.WeatherService;
import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

@Controller
public class ListingGraphController {

  private final AirBnBListingRepository airBnBListingRepository;
  private final WeatherService weatherService;

  public ListingGraphController(AirBnBListingRepository airBnBListingRepository, WeatherService weatherService) {
    this.airBnBListingRepository = airBnBListingRepository;
    this.weatherService = weatherService;
  }

  @QueryMapping
  public Page<ListingsAndReview> airbnbListings( @Argument int page, @Argument int size) {
    Pageable pageRequest = PageRequest.of(page, size);
    return airBnBListingRepository.findAll(pageRequest);
  }

  @QueryMapping
  public ListingsAndReview airbnbListingById(@Argument String id) {
    return airBnBListingRepository.findById(id).get();
  }

  @SchemaMapping
  public Weather weather(Location location){
    Optional<WeatherResponse> waResponse = weatherService.getCurrentWeatherByLatLong(location.getLat(), location.getLong());
    if(waResponse.isPresent())
      return waResponse.get().toWeather();
    
    return null;
  }

}
