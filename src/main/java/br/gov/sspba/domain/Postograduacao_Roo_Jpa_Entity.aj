// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Postograduacao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Postograduacao_Roo_Jpa_Entity {
    
    declare @type: Postograduacao: @Entity;
    
    declare @type: Postograduacao: @Table(name = "postograduacao");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPostoGraduacao")
    private Integer Postograduacao.idPostoGraduacao;
    
    public Integer Postograduacao.getIdPostoGraduacao() {
        return this.idPostoGraduacao;
    }
    
    public void Postograduacao.setIdPostoGraduacao(Integer id) {
        this.idPostoGraduacao = id;
    }
    
}
