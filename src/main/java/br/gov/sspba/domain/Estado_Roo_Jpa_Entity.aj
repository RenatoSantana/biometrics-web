// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Estado;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Estado_Roo_Jpa_Entity {
    
    declare @type: Estado: @Entity;
    
    declare @type: Estado: @Table(name = "estado");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEstado")
    private Integer Estado.idEstado;
    
    public Integer Estado.getIdEstado() {
        return this.idEstado;
    }
    
    public void Estado.setIdEstado(Integer id) {
        this.idEstado = id;
    }
    
}
