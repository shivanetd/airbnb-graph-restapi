package com.shiva.airbingraphqlapi.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;
import com.shiva.airbingraphqlapi.repository.AirBnBListingRepository;

@Controller
public class ListingGraphController {

  private AirBnBListingRepository airBnBListingRepository;

  public ListingGraphController(AirBnBListingRepository airBnBListingRepository) {
    this.airBnBListingRepository = airBnBListingRepository;
  }

  @QueryMapping
  public List<ListingsAndReview> airbnbListings() {
    return airBnBListingRepository.findAll();
  }

  @QueryMapping
  public ListingsAndReview airbnbListingById(@Argument String id) {
    return airBnBListingRepository.findById(id).get();
  }

}
