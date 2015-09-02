package br.gov.sspba.domain;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "dadobiometrico")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "funcionarios" })
public class Dadobiometrico implements Serializable {

    public static TypedQuery<Dadobiometrico> findDadoBiometricoByMatricula(String matricula) {
        EntityManager em = Funcionario.entityManager();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT o FROM Dadobiometrico AS o ");
        if (matricula != null && matricula.length() != 0) sb.append(" WHERE o.matricula = :matricula ");
        TypedQuery<Dadobiometrico> q = em.createQuery(sb.toString(), Dadobiometrico.class);
        if (matricula != null && matricula.length() != 0) q.setParameter("matricula", matricula);
        return q;
    }

    public int hashCode() {
        return this.getIdDadoBiometrico();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Dadobiometrico)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Dadobiometrico dado = (Dadobiometrico) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdDadoBiometrico() == dado.getIdDadoBiometrico();
    }

    @Override
    public String toString() {
        return this.getIdDadoBiometrico().toString();
    }
}
