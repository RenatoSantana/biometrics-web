// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Estadocivil;
import br.gov.sspba.domain.Funcionario;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Estadocivil_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idEstadoCivil")
    private Set<Funcionario> Estadocivil.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Estadocivil.descricao;
    
    public Set<Funcionario> Estadocivil.getFuncionarios() {
        return funcionarios;
    }
    
    public void Estadocivil.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Estadocivil.getDescricao() {
        return descricao;
    }
    
    public void Estadocivil.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
