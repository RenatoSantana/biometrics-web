// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Regiao;
import br.gov.sspba.domain.Unidade;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;

privileged aspect Regiao_Roo_DbManaged {
    
    @OneToMany(mappedBy = "idRegiao")
    private Set<Unidade> Regiao.unidades;
    
    @Column(name = "descricao", length = 45)
    private String Regiao.descricao;
    
    public Set<Unidade> Regiao.getUnidades() {
        return unidades;
    }
    
    public void Regiao.setUnidades(Set<Unidade> unidades) {
        this.unidades = unidades;
    }
    
    public String Regiao.getDescricao() {
        return descricao;
    }
    
    public void Regiao.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
