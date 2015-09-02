// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Sexo;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Sexo_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idSexo")
    private Set<Funcionario> Sexo.funcionarios;
    
    @Column(name = "descricao", length = 15)
    private String Sexo.descricao;
    
    public Set<Funcionario> Sexo.getFuncionarios() {
        return funcionarios;
    }
    
    public void Sexo.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Sexo.getDescricao() {
        return descricao;
    }
    
    public void Sexo.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}