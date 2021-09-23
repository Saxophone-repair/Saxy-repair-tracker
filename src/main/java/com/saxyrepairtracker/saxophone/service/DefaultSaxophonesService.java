package com.saxyrepairtracker.saxophone.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.saxyrepairtracker.saxophone.controller.DefaultEmployeeController;
import com.saxyrepairtracker.saxophone.dao.SaxophonesDao;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import lombok.extern.slf4j.Slf4j;

//@Component
@Service
@Slf4j
public class DefaultSaxophonesService implements SaxophonesService {

  @Autowired
  private SaxophonesDao saxophonesDao;
 
  @Transactional(readOnly = true)
  @Override
  public List<Saxophones> fetchAllSaxophones() {
        List<Saxophones> saxophones = saxophonesDao.fetchAllSaxophones();
        if(saxophones.isEmpty()) {
          String msg = String.format("We have no saxophones");
              throw new NoSuchElementException(msg);
        }
       // Collections.sort((List<Employee>) employees);
        return saxophones;
      }

//  public List<Saxophones> getSaxophonesBySaxophoneType(SaxophonesType type) {
//    // TODO Auto-generated method stub
//    return saxophonesDao.getSaxophonesBySaxophoneType(type);
//  }

  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
      SaxophonesType type) {
    
    return saxophonesDao.createSaxophones(customerFK, manufacturer, series, type);
  }

//  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
//    // TODO Auto-generated method stub
//    return saxophonesDao.getSaxophonesManufacturer(manufacturer);
//  }

  public List<Saxophones> updateSaxophones(Saxophones updatedSaxophones) {
    // TODO Auto-generated method stub
    return saxophonesDao.updateSaxophones(updatedSaxophones);
  }

  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK) {
    // TODO Auto-generated method stub
    return saxophonesDao.fetchAllSaxophonesByCustomer(customerFK);
  }

  @Override
  public List<Saxophones> createSaxophones(Saxophones saxophones) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Saxophones> fetchSaxophones(SaxophonesType type) {
    // TODO Auto-generated method stub
    return saxophonesDao.fetchSaxophones(type);
  }
  
  /**
   * Searches the titles for any occurrences of the specified name.
   * @param name The regular expression or part of the name we want to search.4
   * @return Returns the matching titles if found, otherwise returns an empty list.
   */
//  List<Saxophones> search(SaxophonesType type) {
//   return null;
// }
  
  /**
   * Creates a new title.
   * @param newTitle The new title information.
   * @return The new title information that was created and/or validated, or returns null if operation failed.
   */
//  
//  Saxophones create(Saxophones saxophonesPK) {
//   return null;
// }
  
//  /**
//   * Deletes or removes a title.
//   * @param id The unique id of the title.
//   * @return True if deleted, false if title doesn't exist or deletion failed.
//   */
//  Saxophones delete(String id);
  
//  /**
//   * Updates a title with new information.
//   * @param id The unique id of the title.
//   * @param updatedTitle The updated or new title information. 
//   * @return Returns the updated title information, or null if update fails.
//   */
//  Saxophones update(String id, Saxophones update) {
//   return null;
// }
  
//  /**
//   * Retrieves a single title by id.
//   * @param id The unique id of the title.
//   * @return The title if found, null if otherwise.
//   */
//  Saxophones get(String id) {
//   return null;
// }

// public List<Saxophones> createSaxophones(Saxophones saxophones) {
//   // TODO Auto-generated method stub
//   return saxophonesDao.createSaxophones(saxophones);
// }


//public List<Saxophones> getSaxophonesByManufacturer(String manufacturer) {
//// TODO Auto-generated method stub
//return null;
//}
}
