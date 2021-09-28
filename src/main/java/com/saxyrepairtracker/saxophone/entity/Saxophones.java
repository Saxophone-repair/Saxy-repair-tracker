package com.saxyrepairtracker.saxophone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Saxophones {

  private int saxophonesPK;
  
  private int customerFK;
  
  private int serialNumber;
  
  private String manufacturer;
  
  private String series;
  
  private SaxophonesType saxophonesType;
  
//  @JsonIgnore
//  private List<Customer> customer;
//
//  public List<Saxophones> updateSaxophones(int customerFK, String series, String manufacturer) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public List<Saxophones> createSaxophones(Saxophones saxophones) {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public List<Saxophones> getSaxophones() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  public List<Saxophones> getSaxophones(String manufacturer2) {
//    // TODO Auto-generated method stub
//    return null;
//  }
  
}
