package com.saxyrepairtracker.saxophone.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItem;
import com.saxyrepairtracker.saxophone.entity.ServiceLineItemStatus;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultServiceLineItemDao implements ServiceLineItemDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  @Override
  public List<ServiceLineItem> fetchAllServiceLineItems() {
    log.info("In serviceLineItemDao.fetchAllServiceLineItem()");
    
    // @formatter:off
    String sql = ""
        +"SELECT * "
        + "FROM service_line_item;";
    // @formatter:on  
   
    Map<String, Object> params = new HashMap<>();
    return jdbcTemplate.query(sql, params,
        new RowMapper<ServiceLineItem>() {
          @Override
          public ServiceLineItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return ServiceLineItem.builder()
                .serviceLineItemPK(rs.getInt("service_line_item_pk"))
                .serviceFK(rs.getInt("service_fk"))
                .employeeFK(rs.getInt("employee_fk"))
                .description(rs.getString("description"))
                .serviceLineItemStatus(ServiceLineItemStatus.valueOf(rs.getString("description")))
                .isComplete(rs.getBoolean("is_complete"))
                .timeForRepair(rs.getBigDecimal("time_for_repair"))
                .cost(rs.getBigDecimal("cost"))
                .build();
            // @formatter:on
          }});
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItem(int serviceFK) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM service_line_item "
        + "WHERE service_fk = :service_fk ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("service_fk", serviceFK);
      
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
          @Override
          public ServiceLineItem mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
          return ServiceLineItem.builder()
              .serviceLineItemPK(rs.getInt("service_line_item_pk"))
              .serviceFK(rs.getInt("service_fk"))
              .employeeFK(rs.getInt("employee_fk"))
              .description(rs.getString("description"))
              .serviceLineItemStatus(ServiceLineItemStatus.valueOf(rs.getString("service_line_item_status")))
              .isComplete(rs.getBoolean(rowNum))
              .timeForRepair(rs.getBigDecimal("time_for_repair"))
              .cost(rs.getBigDecimal("cost)"))
              .build();
       // @formatter:on
          }
      });
          
  }

  @Override
  public ServiceLineItem createServiceLineItem(int serviceFK, int employeeFK, String description,
      ServiceLineItemStatus ServiceLineItemStatus, boolean isComplete, BigDecimal timeForRepair,
      BigDecimal cost) {
    
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = ""
        + "INSERT into service_line_item "
        + "(service_fk, employee_fk, description, service_line_item_status, "
        +                                "is_complete, time_for_repair, cost) " 
        + "VALUES (:service_fk, :employee_fk, :description, :service_line_item_status, "
        +                                ":is_complete, :time_for_repair, :cost)" ;
    sqlparams.source.addValue("service_fk", serviceFK);
    sqlparams.source.addValue("employee_fk", employeeFK);
    sqlparams.source.addValue("description", description);
    sqlparams.source.addValue("service_line_item_status", ServiceLineItemStatus.toString());
    sqlparams.source.addValue("is_complete", isComplete);
    sqlparams.source.addValue("time_for_repair", timeForRepair);
    sqlparams.source.addValue("cost", cost);

    

    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return ServiceLineItem.builder()
        .serviceLineItemPK(keyHolder.getKey().intValue())
        .serviceFK(serviceFK)
        .employeeFK(employeeFK)
        .description(description)
        .serviceLineItemStatus(ServiceLineItemStatus)
        .isComplete(isComplete)
        .timeForRepair(timeForRepair)
        .cost(cost)
        .build();
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }


  @Override
  public ServiceLineItem updateServiceLineItem(int serviceLineItemPK, ServiceLineItem updatedItem) {
    // @formatter:off
    String sql = ""
        + "UPDATE service_line_item "
        + "SET "
        + "service_fk = :service_fk, "
        + "employee_fk = :employee_fk, "
        + "description = :description, "
        + "service_line_item_status = :service_line_item_status, "
        + "is_complete = :is_complete, "
        + "time_for_repair = :time_for_repair, "
        + "cost = :cost "
        + "WHERE service_line_item_pk = :service_line_item_pk;";
    // @formatter:on
        
        Map<String, Object> params = new HashMap<>();
        params.put("service_fk", updatedItem.getServiceFK());
        params.put("employee_fk", updatedItem.getEmployeeFK());
        params.put("description", updatedItem.getDescription());
        params.put("service_line_item_status", updatedItem.getServiceLineItemStatus().toString());
        params.put("is_complete", updatedItem.isComplete());
        params.put("time_for_repair", updatedItem.getTimeForRepair());
        params.put("cost", updatedItem.getCost());
        params.put("service_line_item_pk", serviceLineItemPK);    
    
        
    if (jdbcTemplate.update(sql, params) == 0) {
    throw new NoSuchElementException("update failed :( ");
   }
    return ServiceLineItem.builder()
        .serviceLineItemPK(serviceLineItemPK)
        .serviceFK(updatedItem.getServiceFK())
        .employeeFK(updatedItem.getEmployeeFK())
        .description(updatedItem.getDescription())
        .serviceLineItemStatus(updatedItem.getServiceLineItemStatus())
        .isComplete(updatedItem.isComplete())
        .timeForRepair(updatedItem.getTimeForRepair())
        .cost(updatedItem.getCost())
        .build();
  }

  @Override
  public List<ServiceLineItem> fetchAServiceLineItemByStatus(
      ServiceLineItemStatus ServiceLineItemStatus) {
    // @formatter:off
    String sql = ""
        + "FROM service_line_item "
        + "WHERE service_line_item_status = :service_line_item_status ";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("service_repair_item_status", ServiceLineItemStatus.toString());
    
    return jdbcTemplate.query(sql,  params, 
        new RowMapper<>() {
        @Override
        public ServiceLineItem mapRow(ResultSet rs, int rowNum) throws SQLException {
          // @formatter:off
          return ServiceLineItem.builder()
              .serviceLineItemPK(rs.getInt("service_line_item_pk"))
              .serviceFK(rs.getInt("service_fk"))
              .employeeFK(rs.getInt("employee_fk"))
              .description(rs.getString("description"))
              .serviceLineItemStatus(ServiceLineItemStatus.valueOf(rs.getString("service_line_item_status")))
              .isComplete(rs.getBoolean(rowNum))
              .timeForRepair(rs.getBigDecimal("time_for_repair"))
              .cost(rs.getBigDecimal("cost)"))
              .build();
          // @formatter:on
        }
    
      });
    }
}
