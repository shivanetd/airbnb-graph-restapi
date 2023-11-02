package com.shiva.airbingraphqlapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shiva.airbingraphqlapi.repository.AccuWeatherRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {


  @Value("${accu.weather.base.url}")
  private String accuWatherBaseUrl;

  @Bean
  public AccuWeatherRepository createAccuWeatherRepository(){
    Retrofit retrofit = buildRetrofit(accuWatherBaseUrl);
    return retrofit.create(AccuWeatherRepository.class);
  }
  
  private Retrofit buildRetrofit(String baseUrl) {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }
}
