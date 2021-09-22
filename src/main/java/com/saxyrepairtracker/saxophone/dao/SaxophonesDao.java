package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;

public interface SaxophonesDao {
  List<Saxophones> fetchAllSaxophones(int customerFK); 
  
//  List<Saxophones> getSaxophonesByType(SaxophonesType type, int customerFK);
  
  List<Saxophones> getSaxophonesByManufacturer(String manufacturer, int customerFK);

//  List<Saxophones> createSaxophones(Saxophones saxophones);

  List<Saxophones> getSaxophones();

  List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type);

  static List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
                                              SaxophonesType type) {
    // TODO Auto-generated method stub
    return null;
  }

  List<Saxophones> getSaxophonesManufacturer(String manufacturer);

  List<Saxophones> updateSaxophones(Saxophones updatedSaxophone);
  }
  