package br.gov.sspba.domain;
import java.io.Serializable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "comando")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "unidades" })
public class Comando implements Serializable {

    public int hashCode() {
        return this.getIdComando();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Comando)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Comando comando = (Comando) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdComando() == comando.getIdComando();
    }

    @Override
    public String toString() {
        return this.getIdComando().toString();
    }
}
