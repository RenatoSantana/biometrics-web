// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Fatorrh;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Fatorrh_Roo_Jpa_Entity {
    
    declare @type: Fatorrh: @Entity;
    
    declare @type: Fatorrh: @Table(name = "fatorrh");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFatorRH")
    private Integer Fatorrh.idFatorRh;
    
    public Integer Fatorrh.getIdFatorRh() {
        return this.idFatorRh;
    }
    
    public void Fatorrh.setIdFatorRh(Integer id) {
        this.idFatorRh = id;
    }
    
}
