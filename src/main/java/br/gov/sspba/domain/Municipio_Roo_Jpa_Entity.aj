// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Municipio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Municipio_Roo_Jpa_Entity {
    
    declare @type: Municipio: @Entity;
    
    declare @type: Municipio: @Table(name = "municipio");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMunicipio")
    private Integer Municipio.idMunicipio;
    
    public Integer Municipio.getIdMunicipio() {
        return this.idMunicipio;
    }
    
    public void Municipio.setIdMunicipio(Integer id) {
        this.idMunicipio = id;
    }
    
}
