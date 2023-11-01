package com.shiva.airbingraphqlapi.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "listingsAndReviews")
public class ListingsAndReview {
  
  @Id
  public String _id;

  public String listing_url;

  public String name;

  public String summary;

  public String space;

  public String description;

  public String neighborhood_overview;

  public String notes;

  public String transit;  

  public String access;

  public String interaction;

  public String house_rules;

  public String property_type;

  public String room_type;

  public String bed_type;

  public String minimum_nights;

  public String maximum_nights;

  public String cancellation_policy;

  public Date last_scraped;

  public Date calendar_last_scraped;

  public int accommodates;

  public int bedrooms;

  public int beds;

  public int number_of_reviews;

  public int bathrooms;

  public int guests_included;

  public double price;

  public double extra_people;

  public List<String> amenities;
  
  public Image images;
  public Host host;

  public Address address;

  public Availability availability;

  public ReviewScores review_scores;

  public List<Review> reviews;
}
