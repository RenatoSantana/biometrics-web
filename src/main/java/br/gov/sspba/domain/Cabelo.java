package br.gov.sspba.domain;
import java.io.Serializable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "cabelo")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "funcionarios" })
public class Cabelo implements Serializable {

    public int hashCode() {
        return this.getIdCabelo();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Cabelo)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Cabelo cabelo = (Cabelo) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdCabelo() == cabelo.getIdCabelo();
    }

    @Override
    public String toString() {
        return this.getIdCabelo().toString();
    }
}
