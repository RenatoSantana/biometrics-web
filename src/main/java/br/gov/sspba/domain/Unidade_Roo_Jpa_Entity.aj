// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Unidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Unidade_Roo_Jpa_Entity {
    
    declare @type: Unidade: @Entity;
    
    declare @type: Unidade: @Table(name = "unidade");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUnidade")
    private Integer Unidade.idUnidade;
    
    public Integer Unidade.getIdUnidade() {
        return this.idUnidade;
    }
    
    public void Unidade.setIdUnidade(Integer id) {
        this.idUnidade = id;
    }
    
}