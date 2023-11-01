package com.shiva.airbingraphqlapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;

public interface AirBnBListingRepository extends MongoRepository<ListingsAndReview, String>{
  
  Optional<ListingsAndReview> findById(String _id);

  List<ListingsAndReview> findByBedsGreaterThan(int beds);

}
