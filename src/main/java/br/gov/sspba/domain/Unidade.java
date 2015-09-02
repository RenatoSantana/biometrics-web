package br.gov.sspba.domain;
import java.io.Serializable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "funcionarios", "idRegiao", "idMunicipio", "comandoes" })
@RooJpaActiveRecord(versionField = "", table = "unidade", finders = { "findUnidadesByIdComandoEquals" })
public class Unidade implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idComando", referencedColumnName = "idComando", nullable = true)
    private Comando idComando;

    public int hashCode() {
        return this.getIdUnidade();
    }

    @Override
    public boolean equals(Object obj) {
        //se nao forem objetos da mesma classe sao objetos diferentes
        if (!(obj instanceof Unidade)) return false;
        //se forem o mesmo objeto, retorna true
        if (obj == this) return true;
        // aqui o cast é seguro por causa do teste feito acima
        Unidade dado = (Unidade) obj;
        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
        return this.getIdUnidade() == dado.getIdUnidade();
    }

    @Override
    public String toString() {
        return this.getIdUnidade().toString();
    }

    public Comando getIdComando() {
        return idComando;
    }

    public void setIdComando(Comando idComando) {
        this.idComando = idComando;
    }
}
