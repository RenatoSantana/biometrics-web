// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Olho;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Olho_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idOlho")
    private Set<Funcionario> Olho.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Olho.descricao;
    
    public Set<Funcionario> Olho.getFuncionarios() {
        return funcionarios;
    }
    
    public void Olho.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Olho.getDescricao() {
        return descricao;
    }
    
    public void Olho.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}