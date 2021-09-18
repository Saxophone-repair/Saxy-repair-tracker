package com.saxyrepairtracker.saxophone.dao;

import java.util.List;
import com.saxyrepairtracker.saxophone.entity.Saxophones;

public interface SaxophonesDao {
  List<Saxophones> fetchSaxophones(String SaxophonesType, int customerFK); //How does one reference an enum for this to search by?
}
