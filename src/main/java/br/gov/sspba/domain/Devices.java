package br.gov.sspba.domain;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooSerializable
public class Devices {
	
	  @ManyToOne
	  @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario", nullable = false)
	  private Funcionario idFuncionario;
	  
	  @NotNull
	  private String imei;
	  
	  

}
