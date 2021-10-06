package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;

public interface SaxophonesDao {
  
  //SaxophonesDao takes everything from the service layer and begins to implement it.
  //Afterwards, passes it off to the default Saxophone Dao.
  
  List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK);                        //!!!
  
//  List<Saxophones> getSaxophonesByType(SaxophonesType type, int customerFK);
  
//  List<Saxophones> getSaxophonesByManufacturer(String manufacturer, int customerFK);

//  List<Saxophones> createSaxophones(Saxophones saxophones);

  List<Saxophones> fetchAllSaxophones();                                                //!!!

//  List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type);

  Saxophones createSaxophones(int customerFK, int serialNumber, String manufacturer, String series, //!!!
                                              SaxophonesType type);
  
//  List<Saxophones> getSaxophonesManufacturer(String manufacturer);

  Saxophones updateSaxophones(int saxophonesPK, Saxophones updatedSaxophones);            

  List<Saxophones> fetchSaxophones(SaxophonesType type);                                 //!!!
  }
  