package com.shiva.airbingraphqlapi.model;

import java.util.List;

public class Location {

  public String type;

  public List<String> coordinates;

  public boolean is_location_exact;
  
  public Weather weather;

  public String getLat(){
    return this.getIndexOf(0);
  }

  public String getLong(){
    return this.getIndexOf(1);
  }

  private String getIndexOf(int index){
    if(this.coordinates != null && this.coordinates.size()==2)
      return this.coordinates.get(index);
    
    return "";
  }
}
