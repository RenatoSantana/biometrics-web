package br.gov.sspba.domain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;



@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(finders = { "findUserRolesByPermissions", "findUserRolesByRoleAccounts", "findUserRolesByRoleNameEquals", "findUserRolesByRoleNameLike" })
public class UserRole implements Serializable {

	 public int hashCode() {
	        return this.getId().intValue();
	    }

	    @Override
	    public boolean equals(Object obj) {
	        //se nao forem objetos da mesma classe sao objetos diferentes
	        if (!(obj instanceof UserRole)) return false;
	        //se forem o mesmo objeto, retorna true
	        if (obj == this) return true;
	        // aqui o cast é seguro por causa do teste feito acima
	        UserRole dado = (UserRole) obj;
	        //aqui você compara a seu gosto, o ideal é comparar atributo por atributo
	        return this.getId() == dado.getId();
	    }

	    @Override
	    public String toString() {
	        return this.getId().toString();
	    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "permissionRoles")
    private Set<UserPermission> permissions = new HashSet<UserPermission>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "userRole")
    private Set<UserAccount> roleAccounts = new HashSet<UserAccount>();
    

    
}
