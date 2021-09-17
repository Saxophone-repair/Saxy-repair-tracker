package com.saxyrepairtracker.saxophone.entity;

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
  
  private SaxophonesType saxophoneType;
  
}
