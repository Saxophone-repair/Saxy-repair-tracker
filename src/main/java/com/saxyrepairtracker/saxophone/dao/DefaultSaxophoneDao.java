package com.saxyrepairtracker.saxophone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.Customer;
import com.saxyrepairtracker.saxophone.entity.Saxophones;
import com.saxyrepairtracker.saxophone.entity.SaxophonesType;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultSaxophoneDao {
  @Autowired
  private static NamedParameterJdbcTemplate jdbcTemplate;
      //Retrieve data from database and returns to service layer
  
  public Optional<Customer> fetchAllSaxophones(int customerFK) {
    
//    log.info("In saxophones.dao.getSaxophones");
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM customer "
        + "WHERE customer_id = :customer_id";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerFK);
    // return null
    return Optional.ofNullable(
        jdbcTemplate.query(sql,  params, new CustomerResultSetExtractor()));
  }
  
  public static SaxophonesType getSaxophoneByType(SaxophonesType type) {
    log.info("Pulls Saxophones in service layer with the specified SaxophonesType");
      return type;
  }

  public static String getSaxophoneManufacturer(String manufacturer) {
     log.info("Pulls Saxophones in service layer with certain manufacturer's");
      return manufacturer;
    }
    
  
  public List<Saxophones> getSaxophones() {
    log.info("In saxophones.dao.getCustomers");
    
        // @formatter:off
        String sql = ""
            + "SELECT * "
            + "FROM saxophones; ";
        // @formatter:on
        
        return jdbcTemplate.query(sql,
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
                    .saxophonesType(SaxophonesType.valueOf(rs.getString("saxophones_type")))
                    .build();
                // @formatter:on
              }
        });
  }
  
  public static Saxophones updateSaxophones(Saxophones saxophones) {
    log.info("create Saxophones in service layer");
    return saxophones;
  }
  
//  private void saveSaxophones(List<Saxophones> saxophones, int saxophonesPK) {
//    for(Saxophones saxophones : saxophones) {
//      SqlParams params = generateInsertSql(saxophones, saxophonesPK);
//      jdbcTemplate.update(params.sql, params.source);
//    }
//  }
//  
//private SqlParams generateInsertSql(Saxophones saxophones, int saxophonesPK) {
//  SqlParams params = new SqlParams();
//  
//  // @formatter:off
//  params.sql = ""
//      + "INSERT INTO saxophones ("
//      + "saxophones_pk :saxophones_pk"
//      + ") VALUES ("
//      + ":saxophones_pk, :saxophones_pk"
//      + ")";
//  // @formatter:on
//  
//        //?
//  params.source.addValue("option_fk", saxophones.getSaxophonesPK());
//  params.source.addValue("order_fk", SaxophonesPK);
//  
//  return params;
//}






  

//  public List<Saxophones> fetchSaxophones(int customerFK, String manufacturer, String series, SaxophonesType type) {
//    
//    return null;
//  }
  
  class CustomerResultSetExtractor implements ResultSetExtractor<Customer> {
    @Override
    public Customer extractData(ResultSet rs) throws SQLException {
      rs.next();

      // @formatter:off
      return Customer.builder()
          .customerPK(rs.getInt("customer_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phone(rs.getString("phone"))
          .build();
      // @formatter:on

    }
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
