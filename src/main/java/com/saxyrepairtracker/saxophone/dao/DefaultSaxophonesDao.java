package com.saxyrepairtracker.saxophone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSaxophonesDao implements SaxophonesDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
      //Retrieve data from database and returns to service layer
    
@Override //!!!
  public List<Saxophones> fetchAllSaxophones() {                                              //!!!
    log.info("In saxophones.dao.fetchAllSaxophones");
    
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM saxophones ";
        // @formatter:on
        
        Map<String, Object> params = new HashMap<>();
        return jdbcTemplate.query(sql, params,
            new RowMapper<Saxophones>() {
              @Override
              public Saxophones mapRow(ResultSet rs, int rowNum) throws SQLException {
                // @formatter:off
                return Saxophones.builder()
                    .saxophonePK(rs.getInt("saxophones_pk"))
                    .customerFK(rs.getInt("customer_fk"))
                    .serialNumber(rs.getInt("serial_number"))
                    .manufacturer(rs.getString("manufacturer"))
                    .series(rs.getString("series"))
                    .saxophonesType(SaxophonesType.valueOf(rs.getString("type")))
                    .build();
                // @formatter:on
              }
        });
  }


  @Override
  public List<Saxophones> createSaxophones(int customerFK, String manufacturer, String series,
      SaxophonesType type) {
    // TODO Auto-generated method stub
    return null;
  }

//  @Override
//  public List<Saxophones> getSaxophonesManufacturer(String manufacturer) {
//    // TODO Auto-generated method stub
//    return null;
//  }

  @Override
  public List<Saxophones> fetchAllSaxophonesByCustomer(int customerFK) {                       //!!!
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM saxophones "
        + "WHERE customer_fk = :customer_fk ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_fk", customerFK);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public Saxophones mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Saxophones.builder()
                .saxophonePK(rs.getInt("saxophones_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .serialNumber(rs.getInt("serial_number"))
                .manufacturer(rs.getString("manufacturer"))
                .series(rs.getString("series"))
                .saxophonesType(SaxophonesType.valueOf(rs.getString("type")))
                .build();
            // @formatter:on
          }
    });    
  }

  @Override
  public List<Saxophones> updateSaxophones(Saxophones updatedSaxophones) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Saxophones> fetchSaxophones(SaxophonesType type) {                               //!!!
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM saxophones "
        + "WHERE type = :type ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("type", type.toString());
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public Saxophones mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Saxophones.builder()
                .saxophonePK(rs.getInt("saxophones_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .serialNumber(rs.getInt("serial_number"))
                .manufacturer(rs.getString("manufacturer"))
                .series(rs.getString("series"))
                .saxophonesType(SaxophonesType.valueOf(rs.getString("type")))
                .build();
            // @formatter:on
          }
    });    
  }
}
