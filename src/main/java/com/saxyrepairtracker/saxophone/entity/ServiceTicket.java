package com.saxyrepairtracker.saxophone.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTicket {

  private int servicePk;
  private int customerFk;
  private String description;
  private Status status;
  private BigDecimal estimatedCost;
  private BigDecimal actualCost;
//  CREATE TABLE service_ticket (
//      service_pk int unsigned NOT NULL AUTO_INCREMENT,
//      customer_fk int unsigned NOT NULL,                  
//      description varchar(400) NOT NULL,
//      status enum('AWAITING ARRIVAL', 'WAITING FOR REPAIR', 'BEING REPAIRED', 
//                  'WAITING FOR PARTS', 'READY FOR PICK-UP', 'PICKED-UP') NOT NULL,
//      estimated_cost decimal(9, 2) NOT NULL,
//      actual_cost decimal(9, 2),
//      PRIMARY KEY (service_pk),
//      FOREIGN KEY (customer_fk) REFERENCES customer(customer_pk)
//      -- UNIQUE KEY (service_pk, description, status, estimated_cost, actual_cost)
//      );
    

}
