// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Graudeinstrucao;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Graudeinstrucao_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idGrauDeInstrucao")
    private Set<Funcionario> Graudeinstrucao.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Graudeinstrucao.descricao;
    
    public Set<Funcionario> Graudeinstrucao.getFuncionarios() {
        return funcionarios;
    }
    
    public void Graudeinstrucao.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Graudeinstrucao.getDescricao() {
        return descricao;
    }
    
    public void Graudeinstrucao.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}