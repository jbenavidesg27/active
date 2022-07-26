package com.nttdata.bootcamp.active.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Getter,Setter and Constructors*/
@Data
@AllArgsConstructor
@NoArgsConstructor
/*Document Mapping -> MongoDB*/
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