package com.shiva.airbingraphqlapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;
import com.shiva.airbingraphqlapi.repository.AirBnBListingRepository;
import com.shiva.airbingraphqlapi.service.weather.WeatherService;
import com.shiva.airbingraphqlapi.service.weather.model.WeatherResponse;

@RestController
public class ListingController {
  
  private final AirBnBListingRepository airBnBListingRepository;
  private final WeatherService weatherService;

  public ListingController(AirBnBListingRepository airBnBListingRepository, WeatherService weatherService) {
    this.airBnBListingRepository = airBnBListingRepository;
    this.weatherService = weatherService;
  }

  @GetMapping("/listings")
  public List<ListingsAndReview> getListings() {
    return airBnBListingRepository.findAll();
  }


  public @GetMapping("/listings/{listingId}") Optional<ListingsAndReview> getListingById(@PathVariable("listingId") String id) {
    return airBnBListingRepository.findById(id);
  }

  public @GetMapping("/listings/bed") List<ListingsAndReview> getListingGreaterThan(@RequestParam("beds") int beds) {
    return airBnBListingRepository.findByBedsGreaterThan(beds);
  }

  @GetMapping("/wether")
  public Optional<WeatherResponse> getWeather(@RequestParam("lat") String lat,@RequestParam("long") String longitude){
    return weatherService.getCurrentWeatherByLatLong(lat,longitude);
  }

}
