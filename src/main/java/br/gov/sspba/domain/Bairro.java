package br.gov.sspba.domain;

import java.io.Serializable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "logradourobairrounidades", "idMunicipio" })
@RooJpaActiveRecord(versionField = "", table = "bairro", finders = { "findBairroesByIdMunicipio" })
public class Bairro implements Serializable {

    public int hashCode() {
        if (this.getIdBairro() != null) return this.getIdBairro(); else return 0;
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Bairro)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast ÃƒÂ© seguro por causa do teste feito acima
        Bairro dado = (Bairro) obj;
        //aqui vocÃƒÂª compara a seu gosto, o ideal ÃƒÂ© comparar atributo por atributo
        return this.getIdBairro() == dado.getIdBairro();
    }
}