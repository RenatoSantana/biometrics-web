// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Devices;
import br.gov.sspba.domain.Funcionario;

privileged aspect Devices_Roo_JavaBean {
    
    public Funcionario Devices.getIdFuncionario() {
        return this.idFuncionario;
    }
    
    public void Devices.setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public String Devices.getImei() {
        return this.imei;
    }
    
    public void Devices.setImei(String imei) {
        this.imei = imei;
    }
    
}
