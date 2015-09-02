package br.gov.sspba.domain;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooSerializable
public class CategoriaCNH implements Serializable {

	
	@NotNull
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	 public int hashCode() {
	        return this.getId();
	    }

	    @Override
	    public boolean equals(Object obj) {
	        //se nao forem objetos da mesma classe sao objetos diferentes
	        if (!(obj instanceof CategoriaCNH)) return false;
	        //se forem o mesmo objeto, retorna true
	        if (obj == this) return true;
	        // aqui o cast é seguro por causa do teste feito acima
	        CategoriaCNH dado = (CategoriaCNH) obj;
	        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
	        return this.getId() == dado.getId();
	    }

	 //   @Override
	    public String toString() {
	        return this.getId().toString();
	    }
	
}
