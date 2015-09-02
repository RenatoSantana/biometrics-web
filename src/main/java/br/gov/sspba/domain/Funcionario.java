package br.gov.sspba.domain;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "notagerals", "idBarba", "idBigode", "idCabelo", "idCutis", "idDadoBiometrico", "idEstadoCivil", "idFatorRh", "idGrauDeInstrucao", "idGrupoSanguineo", "idNotaAnomala", "idOlho", "idPostoGraduacao", "idQuadro", "idSexo", "idSituacaoPolicial", "idTipoCertidao", "idUnidade", "idMunicipioResidente" })
@RooJpaActiveRecord(versionField = "", table = "funcionario", finders = { "findFuncionariosByMatriculaEquals", "findFuncionariosByMatriculaEqualsOrNomeEqualsOrSobrenomeEquals" })
public class Funcionario implements Serializable {

    @Column(name = "dataCertidao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dataCertidao;

    @Column(name = "enabledAutExpeditora", unique = true)
    private String enabledAutExpeditora;

    @Column(name = "orgaoExpedidor")
    private String orgaoExpedidor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoriaCNH", referencedColumnName = "id", nullable = true)
    private CategoriaCNH idCategoriaCNH;
    
    @ManyToOne
    @JoinColumn(name = "idEstadoResidente", referencedColumnName = "idEstado", nullable = false)
    private Estado idEstadoResidente;
    
    @ManyToOne
    @JoinColumn(name = "idBairroResidente", referencedColumnName = "idBairro", nullable = false)
    private Bairro idBairroResidente;
    
    
    public Bairro getIdBairroResidente() {
		return idBairroResidente;
	}


	public void setIdBairroResidente(Bairro idBairroResidente) {
		this.idBairroResidente = idBairroResidente;
	}


	public static TypedQuery<Funcionario> findFuncionarioByFilter(String matricula, String cpf, String nome, String sobrenome, boolean autExpeditora) {
        EntityManager em = Funcionario.entityManager();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT o FROM Funcionario AS o ").append(" WHERE 1= 1 and o.autExpeditora = :autExpeditora ");
        if (matricula != null && matricula.length() != 0) sb.append(" AND o.matricula = :matricula ");
        if (cpf != null && cpf.length() != 0) sb.append(" AND o.cpf = :cpf ");
        if (nome != null && nome.length() != 0) sb.append(" AND o.nome like :nome ");
        if (sobrenome != null && sobrenome.length() != 0) sb.append(" AND o.sobrenome like :sobrenome ");
        TypedQuery<Funcionario> q = em.createQuery(sb.toString(), Funcionario.class);
        q.setParameter("autExpeditora", autExpeditora);
        if (matricula != null && matricula.length() != 0) q.setParameter("matricula", matricula);
        if (cpf != null && cpf.length() != 0) q.setParameter("cpf", cpf);
        if (nome != null && nome.length() != 0) q.setParameter("nome", "%" + nome + "%");
        if (sobrenome != null && sobrenome.length() != 0) q.setParameter("sobrenome", "%" + sobrenome + "%");
        return q;
    }


    public int hashCode() {
        if (this.getIdFuncionario() != null) {
            return this.getIdFuncionario();
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Funcionario)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Funcionario dado = (Funcionario) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdFuncionario() == dado.getIdFuncionario();
    }

    @Override
    public String toString() {
        return this.getIdFuncionario().toString();
    }

  
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public CategoriaCNH getIdCategoriaCNH() {
        return idCategoriaCNH;
    }

    public void setIdCategoriaCNH(CategoriaCNH idCategoriaCNH) {
        this.idCategoriaCNH = idCategoriaCNH;
    }




	public Estado getIdEstadoResidente() {
		return idEstadoResidente;
	}


	public void setIdEstadoResidente(Estado idEstadoResidente) {
		this.idEstadoResidente = idEstadoResidente;
	}
    
    
    
}
