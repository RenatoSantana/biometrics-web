// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Cutis;
import br.gov.sspba.domain.Funcionario;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Cutis_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idCutis")
    private Set<Funcionario> Cutis.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Cutis.descricao;
    
    public Set<Funcionario> Cutis.getFuncionarios() {
        return funcionarios;
    }
    
    public void Cutis.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Cutis.getDescricao() {
        return descricao;
    }
    
    public void Cutis.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}