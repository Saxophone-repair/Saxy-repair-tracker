package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saxyrepairtracker.saxophone.dao.CustomerDao;
import com.saxyrepairtracker.saxophone.dao.SaxophonesDao;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;


@Service
public class DefaultSaxophonesService implements SaxophonesService {

  @Autowired
  private SaxophonesDao saxophonesDao;
   /**
    * Searches the titles for any occurrences of the specified name.
    * @param name The regular expression or part of the name we want to search.4
    * @return Returns the matching titles if found, otherwise returns an empty list.
    */
//   List<Saxophones> search(SaxophonesType type) {
//    return null;
//  }
   
   /**
    * Creates a new title.
    * @param newTitle The new title information.
    * @return The new title information that was created and/or validated, or returns null if operation failed.
    */
//   
//   Saxophones create(Saxophones saxophonesPK) {
//    return null;
//  }
   
//   /**
//    * Deletes or removes a title.
//    * @param id The unique id of the title.
//    * @return True if deleted, false if title doesn't exist or deletion failed.
//    */
//   Saxophones delete(String id);
   
//   /**
//    * Updates a title with new information.
//    * @param id The unique id of the title.
//    * @param updatedTitle The updated or new title information. 
//    * @return Returns the updated title information, or null if update fails.
//    */
//   Saxophones update(String id, Saxophones update) {
//    return null;
//  }
   
//   /**
//    * Retrieves a single title by id.
//    * @param id The unique id of the title.
//    * @return The title if found, null if otherwise.
//    */
//   Saxophones get(String id) {
//    return null;
//  }

//  public List<Saxophones> createSaxophones(Saxophones saxophones) {
//    // TODO Auto-generated method stub
//    return saxophonesDao.createSaxophones(saxophones);
//  }

  public List<Saxophones> getSaxophones() {
    // TODO Auto-generated method stub
    return saxophonesDao.getSaxophones();
  }

  public List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type) {
    // TODO Auto-generated method stub
    return saxophonesDao.getSaxophonesBySaxophoneType(type);
  }

  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
      SaxophonesType type) {
    // TODO Auto-generated method stub
    return SaxophonesDao.createSaxophones(customerFK, manufacturer, series, type);
  }

  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
    // TODO Auto-generated method stub
    return saxophonesDao.getSaxophonesManufacturer(manufacturer);
  }

  public List<Saxophones> updateSaxophones(Saxophones updatedSaxophone) {
    // TODO Auto-generated method stub
    return saxophonesDao.updateSaxophones(updatedSaxophone);
  }

  public List<Saxophones> fetchAllSaxophones(int customerId) {
    // TODO Auto-generated method stub
    return saxophonesDao.fetchAllSaxophones(customerId);
  }

  @Override
  public List<Saxophones> createSaxophones(Saxophones saxophones) {
    // TODO Auto-generated method stub
    return null;
  }
  
//public List<Saxophones> getSaxophonesByManufacturer(String manufacturer) {
//// TODO Auto-generated method stub
//return null;
//}
}
