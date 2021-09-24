package com.saxyrepairtracker.saxophone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.saxyrepairtracker.saxophone.entity.ServiceTicket;
import com.saxyrepairtracker.saxophone.entity.Status;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultServiceTicketDao implements ServiceTicketDao{
  @Autowired 
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<ServiceTicket> fetchServiceTicketByStatus(Status status) {
    log.debug("DAO: status={}", status);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM service_ticket "
        + "WHERE status = :status ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("status", status.toString());
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {
            @Override
            public ServiceTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
           // @formatter:off
              return ServiceTicket.builder()
                  .servicePK(rs.getInt("service_pk"))
                  .customerFK(rs.getInt("customer_fk"))
                  .description(rs.getString("description"))
                  .status(Status.valueOf(rs.getString("status")))
                  .estimatedCost(rs.getBigDecimal("estimated_cost"))
                  .actualCost(rs.getBigDecimal("actual_cost"))
                  .build();
           // @formatter:on
          }
    });    
  }

  @Override
  public List<ServiceTicket> fetchAllServiceTickets() {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM service_ticket ";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public ServiceTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return ServiceTicket.builder()
                .servicePK(rs.getInt("service_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .description(rs.getString("description"))
                .status(Status.valueOf(rs.getString("status")))
                .estimatedCost(rs.getBigDecimal("estimated_cost"))
                .actualCost(rs.getBigDecimal("actual_cost"))
                .build();
         // @formatter:on
          }});
  }

  @Override
  public List<ServiceTicket> createServiceTicket(@Valid ServiceTicket newServiceTicket) {
    // @formatter:off
    String sql = ""
        + "INSERT "
        + "INTO service_ticket ("
        + "service_pk, customer_fk, description, "
        + "status, estimated_cost, actual_cost"
        + ") VALUES("
        +" :service_pk, :customer_fk, :description"
        + ":status, :estimated_cost, :actual_cost)";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("service_pk", newServiceTicket.getServicePK());
    params.put("customer_fk", newServiceTicket.getCustomerFK());
    params.put("description", newServiceTicket.getDescription());
    params.put("status", newServiceTicket.getStatus());
    params.put("estimated_cost", newServiceTicket.getEstimatedCost());
    params.put("actual_cost", newServiceTicket.getActualCost());
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public ServiceTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return ServiceTicket.builder()
                .servicePK(rs.getInt("service_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .description(rs.getString("description"))
                .status(Status.valueOf(rs.getString("status")))
                .estimatedCost(rs.getBigDecimal("estimated_cost"))
                .actualCost(rs.getBigDecimal("actual_cost"))
                .build();
         // @formatter:on
          }});
  }

  @Override
  public void deleteServiceTicket(int deleteId) {
    // @formatter:off
    String sql = ""
        + "DELETE FROM service_ticket "
        + "WHERE service_pk = :service_pk;";
    // @formatter:on    
       
    Map<String, Object> params = new HashMap<>();
    
    params.put("service_pk", deleteId);    
    if (jdbcTemplate.update(sql,  params) == 0) throw new NoSuchElementException();
  }

  @Override
  public List<ServiceTicket> updateServiceTicket(int id,
      @Valid ServiceTicket updatedServiceTicket) {
    // @formatter:off
    String sql = ""
        + "UPDATE "
        + "service_ticket SET"
        + "customer_fk = :customer_fk, "
        + "description = :description, "
        + "status = :status, "
        + "estimated_cost = :estimated_cost, "
        + "actual_cost = :actual_cost,"
        + "WHERE service_pk = :service_pk";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_fk", updatedServiceTicket.getCustomerFK());
    params.put("description", updatedServiceTicket.getDescription());
    params.put("status", updatedServiceTicket.getStatus());
    params.put("estimated_cost", updatedServiceTicket.getEstimatedCost());
    params.put("actual_cost", updatedServiceTicket.getActualCost());
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
          @Override
          public ServiceTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
         // @formatter:off
            return ServiceTicket.builder()
                .servicePK(rs.getInt("service_pk"))
                .customerFK(rs.getInt("customer_fk"))
                .description(rs.getString("description"))
                .status(Status.valueOf(rs.getString("status")))
                .estimatedCost(rs.getBigDecimal("estimated_cost"))
                .actualCost(rs.getBigDecimal("actual_cost"))
                .build();
         // @formatter:on
          }});
  }
}
