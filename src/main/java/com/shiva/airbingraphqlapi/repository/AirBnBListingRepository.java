package com.shiva.airbingraphqlapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;

public interface AirBnBListingRepository extends MongoRepository<ListingsAndReview, String>{
  
  Optional<ListingsAndReview> findById(String _id);

  Page<ListingsAndReview> findAll(Pageable pageRequest);

  List<ListingsAndReview> findByBedsGreaterThan(int beds);

}
