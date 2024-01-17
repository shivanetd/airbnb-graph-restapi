package com.shiva.airbingraphqlapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;

import com.shiva.airbingraphqlapi.model.ListingsAndReview;

public interface AirBnBListingRepository extends MongoRepository<ListingsAndReview, String>{
  
  @NonNull Optional<ListingsAndReview> findById(@NonNull String _id);

  @NonNull Page<ListingsAndReview> findAll(@NonNull Pageable pageRequest);

  List<ListingsAndReview> findByBedsGreaterThan(int beds);

}
