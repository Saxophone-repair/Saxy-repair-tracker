package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;

public interface SaxophonesService {
  
  public List<Saxophones> createSaxophones(Saxophones saxophones); 

  public List<Saxophones> getSaxophones(); 
  
  public List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type); 
  
  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
      SaxophonesType type);


  public List<Saxophones> getSaxophonesManufacturer(String manufacturer); 

  public List<Saxophones> updateSaxophones(Saxophones updatedSaxophone); 

  public List<Saxophones> fetchAllSaxophones(int customerId); 
}
