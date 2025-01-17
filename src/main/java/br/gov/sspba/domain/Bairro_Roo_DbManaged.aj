// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;
import br.gov.sspba.domain.Bairro;
import br.gov.sspba.domain.Municipio;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Bairro_Roo_DbManaged {

    
    @ManyToOne
    @JoinColumn(name = "idMunicipio", referencedColumnName = "idMunicipio", nullable = false,unique=true)
    private Municipio Bairro.idMunicipio;
    
    @Column(name = "descricao", length = 45)
    @NotNull
    private String Bairro.descricao;
    
    @Column(name = "dataExclusao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date Bairro.dataExclusao;
    
   
    
    public Municipio Bairro.getIdMunicipio() {
        return idMunicipio;
    }
    
    public void Bairro.setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
    public String Bairro.getDescricao() {
        return descricao;
    }
    
    public void Bairro.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Date Bairro.getDataExclusao() {
        return dataExclusao;
    }
    
    public void Bairro.setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }
    
}
