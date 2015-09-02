// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Cabelo;
import br.gov.sspba.domain.Funcionario;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Cabelo_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idCabelo")
    private Set<Funcionario> Cabelo.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Cabelo.descricao;
    
    public Set<Funcionario> Cabelo.getFuncionarios() {
        return funcionarios;
    }
    
    public void Cabelo.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Cabelo.getDescricao() {
        return descricao;
    }
    
    public void Cabelo.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}