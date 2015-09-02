package br.gov.sspba.domain;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "municipio")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "funcionarios", "unidades", "idEstado" })
public class Municipio implements Serializable {

    public int hashCode() {
        return this.getIdMunicipio();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Municipio)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Municipio dado = (Municipio) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdMunicipio() == dado.getIdMunicipio();
    }
    
    public static TypedQuery<Municipio> findMunicipiosByIdEstadoEquals(Estado idEstado) {
        if (idEstado == null) throw new IllegalArgumentException("The idEstado argument is required");
        EntityManager em = Municipio.entityManager();
        TypedQuery<Municipio> q = em.createQuery("SELECT o FROM Municipio AS o WHERE o.idEstado = :idEstado", Municipio.class);
        q.setParameter("idEstado", idEstado);
        return q;
    }
    

    @Override
    public String toString() {
        return this.getIdMunicipio().toString();
    }
}
