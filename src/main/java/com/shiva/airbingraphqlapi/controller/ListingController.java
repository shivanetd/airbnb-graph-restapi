package com.shiva.airbingraphqlapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;
import com.shiva.airbingraphqlapi.repository.AirBnBListingRepository;

@RestController
public class ListingController {
  
  private AirBnBListingRepository airBnBListingRepository;

  public ListingController(AirBnBListingRepository airBnBListingRepository) {
    this.airBnBListingRepository = airBnBListingRepository;
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
}
