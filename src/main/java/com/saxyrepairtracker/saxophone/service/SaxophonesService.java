package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;

public interface SaxophonesService {
  
  public List<Saxophones> createSaxophones(Saxophones saxophones); 

  public List<Saxophones> fetchAllSaxophones(); //!!! 
  
//  public List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type); 
  
  public Saxophones createSaxophones(int customerFK, int serialNumber, String manufacturer, String series,
                                            SaxophonesType type);

//  public List<Saxophones> getSaxophonesManufacturer(String manufacturer); 

  public Saxophones updateSaxophones(int saxophonePK, Saxophones updatedSaxophones); 

  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK);   //!!!

  public List<Saxophones> fetchSaxophones(SaxophonesType type);    //!!!
}
