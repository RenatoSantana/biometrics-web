package br.gov.sspba.domain;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(finders = { "findUserPermissionsByPermissionNameEquals", "findUserPermissionsByPermissionRoles", "findUserPermissionsByPermissionNameLike" })
public class UserPermission implements Serializable {

 

	@NotNull
    @Column(unique = true)
    private String permissionName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<UserRole> permissionRoles = new HashSet<UserRole>();
    
   
   
    
    
}
