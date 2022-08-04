package com.nttdata.bootcamp.active.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Data -> Getter, Setter and Constructor.
 * Document -> NON-RELATIONAL DATABASE.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "active")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Active {
  
  @Id
  private String id;
  
  /*Puede ser "Prestamo Personal, Prestamo Empresarial y Tarjeta de Credito"*/
  private List<Credit> credit;
  
  private BigDecimal creditAmount;
  
  private String codePerson;
  
  private Date creditDate;
  
  private String period;
  
}