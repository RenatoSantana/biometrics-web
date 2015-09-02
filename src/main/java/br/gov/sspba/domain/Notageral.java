package br.gov.sspba.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "notageral")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "idFuncionario", "userId" })
public class Notageral implements Serializable {
	
    @Column(name = "dataRegistro")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dataRegistro;


    public int hashCode() {
        return this.getIdNotaGeral();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Notageral)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Notageral dado = (Notageral) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdNotaGeral() == dado.getIdNotaGeral();
    }

    @Override
    public String toString() {
        return this.getIdNotaGeral().toString();
    }
    
    
    public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public static TypedQuery<Notageral> findNotaGeralByFilter(Funcionario idFuncionario) {
        EntityManager em = Notageral.entityManager();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT o FROM Notageral AS o ").append(" WHERE  o.idFuncionario = :idFuncionario  order by o.idNotaGeral desc ");
        
        TypedQuery<Notageral> q = em.createQuery(sb.toString(), Notageral.class);
        q.setParameter("idFuncionario", idFuncionario);
      
        return q;
    }
}
