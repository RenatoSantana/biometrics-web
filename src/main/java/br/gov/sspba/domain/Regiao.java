package br.gov.sspba.domain;
import java.io.Serializable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "regiao")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "unidades" })
public class Regiao implements Serializable {

    public int hashCode() {
        return this.getIdRegiao();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Regiao)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Regiao dado = (Regiao) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdRegiao() == dado.getIdRegiao();
    }

    @Override
    public String toString() {
        return this.getIdRegiao().toString();
    }
}
