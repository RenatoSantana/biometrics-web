// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Tipocertidao;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Tipocertidao_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idTipoCertidao")
    private Set<Funcionario> Tipocertidao.funcionarios;
    
    @Column(name = "descricao", length = 45)
    private String Tipocertidao.descricao;
    
    public Set<Funcionario> Tipocertidao.getFuncionarios() {
        return funcionarios;
    }
    
    public void Tipocertidao.setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String Tipocertidao.getDescricao() {
        return descricao;
    }
    
    public void Tipocertidao.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}