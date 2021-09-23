package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;

public interface SaxophonesDao {
  
  List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK); 
  
//  List<Saxophones> getSaxophonesByType(SaxophonesType type, int customerFK);
  
//  List<Saxophones> getSaxophonesByManufacturer(String manufacturer, int customerFK);

//  List<Saxophones> createSaxophones(Saxophones saxophones);

  List<Saxophones> fetchAllSaxophones();

//  List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type);

  List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
                                              SaxophonesType type);
  
//  List<Saxophones> getSaxophonesManufacturer(String manufacturer);

  List<Saxophones> updateSaxophones(Saxophones updatedSaxophones);

  List<Saxophones> fetchSaxophones(SaxophonesType type);
  }
  