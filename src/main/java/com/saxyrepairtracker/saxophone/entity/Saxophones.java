package com.saxyrepairtracker.saxophone.entity;

import java.util.List;
import org.springframework.util.MultiValueMap;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Saxophones {

  private int saxophonePK;
  
  private int customerFK;
  
  private int serialNumber;
  
  private String manufacturer;
  
  private String series;
  
  private SaxophonesType saxophonesType;
  
  @JsonIgnore
  private List<Customer> customer;

  public List<String> updateSaxophones(int customerFK) {
    // TODO Auto-generated method stub
    return null;
  }

//  public MultiValueMap<String, String> updateSaxophones(int customer) {
//    // TODO Auto-generated method stub
//    return null;
//  }

//
//  public MultiValueMap<String, String> createSaxophones(Saxophones saxophones) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public MultiValueMap<String, String> getSaxophones() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public MultiValueMap<String, String> getSaxophones(String manufacturer2) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//  
}
