// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Cutis;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Cutis_Roo_Jpa_Entity {
    
    declare @type: Cutis: @Entity;
    
    declare @type: Cutis: @Table(name = "cutis");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCutis")
    private Integer Cutis.idCutis;
    
    public Integer Cutis.getIdCutis() {
        return this.idCutis;
    }
    
    public void Cutis.setIdCutis(Integer id) {
        this.idCutis = id;
    }
    
}
