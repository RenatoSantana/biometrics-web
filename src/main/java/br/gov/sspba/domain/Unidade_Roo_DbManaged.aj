// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Comando;
import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Municipio;
import br.gov.sspba.domain.Regiao;
import br.gov.sspba.domain.Unidade;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Unidade_Roo_DbManaged {
    
    
    @OneToMany(mappedBy = "idUnidade")
    private Set<Funcionario> Unidade.funcionarios;
    
    @ManyToOne
    @JoinColumn(name = "idRegiao", referencedColumnName = "idRegiao", nullable = false)
    private Regiao Unidade.idRegiao;
    
    @ManyToOne
    @JoinColumn(name = "idMunicipio", referencedColumnName = "idMunicipio", nullable = false)
    private Municipio Unidade.idMunicipio;
    
    @Column(name = "descricao", length = 45)
    private String Unidade.descricao;
    
    @Column(name = "dataExclusao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date Unidade.dataExclusao;
    
 
    public Set<Funcionario> Unidade.getFuncionarios() {
        return funcionarios;
    }
    
    public void Unidade.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public Regiao Unidade.getIdRegiao() {
        return idRegiao;
    }
    
    public void Unidade.setIdRegiao(Regiao idRegiao) {
        this.idRegiao = idRegiao;
    }
    
    public Municipio Unidade.getIdMunicipio() {
        return idMunicipio;
    }
    
    public void Unidade.setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
    public String Unidade.getDescricao() {
        return descricao;
    }
    
    public void Unidade.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Date Unidade.getDataExclusao() {
        return dataExclusao;
    }
    
    public void Unidade.setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }
    
}