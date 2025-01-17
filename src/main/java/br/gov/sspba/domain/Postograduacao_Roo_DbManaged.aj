// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Postograduacao;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Postograduacao_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idPostoGraduacao")
    private Set<Funcionario> Postograduacao.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Postograduacao.descricao;
    
    public Set<Funcionario> Postograduacao.getFuncionarios() {
        return funcionarios;
    }
    
    public void Postograduacao.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Postograduacao.getDescricao() {
        return descricao;
    }
    
    public void Postograduacao.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
