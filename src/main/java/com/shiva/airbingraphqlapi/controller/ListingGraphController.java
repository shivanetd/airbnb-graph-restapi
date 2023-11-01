package com.shiva.airbingraphqlapi.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;
import com.shiva.airbingraphqlapi.repository.AirBnBListingRepository;

@Controller
public class ListingGraphController {

  private final AirBnBListingRepository airBnBListingRepository;

  public ListingGraphController(AirBnBListingRepository airBnBListingRepository) {
    this.airBnBListingRepository = airBnBListingRepository;
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

}
