package br.gov.sspba.domain;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "estado")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "municipios" })
public class Estado implements Serializable {

    public int hashCode() {
        return this.getIdEstado();
    }

    @NotNull
    private String sigla;
    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Estado)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Estado dado = (Estado) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdEstado() == dado.getIdEstado();
    }

    @Override
    public String toString() {
        return this.getIdEstado().toString();
    }
}
