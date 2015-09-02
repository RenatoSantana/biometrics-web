// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Notageral;
import br.gov.sspba.domain.UserAccount;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect Notageral_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario", nullable = false)
    private Funcionario Notageral.idFuncionario;
    
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserAccount Notageral.userId;
    
    @Column(name = "descricao", length = 1000)
    private String Notageral.descricao;
    
    public Funcionario Notageral.getIdFuncionario() {
        return idFuncionario;
    }
    
    public void Notageral.setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
    public UserAccount Notageral.getUserId() {
        return userId;
    }
    
    public void Notageral.setUserId(UserAccount userId) {
        this.userId = userId;
    }
    
    public String Notageral.getDescricao() {
        return descricao;
    }
    
    public void Notageral.setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}