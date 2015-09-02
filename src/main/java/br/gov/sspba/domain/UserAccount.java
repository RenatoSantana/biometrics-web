package br.gov.sspba.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;



@RooJavaBean
@RooToString
@RooSerializable
@RooJpaActiveRecord(versionField = "", finders = { "findUserAccountsByUserNameEquals", "findUserAccountsByUserNameLike", "findUserAccountsByUserRole", "findUserAccountsByEmailEquals", "findUserAccountsByEmailLike", "findUserAccountsByEnabledEquals", "findUserAccountsByFirstNameEquals", "findUserAccountsByFirstNameLike", "findUserAccountsByLastNameEquals", "findUserAccountsByLastNameLike", "findUserAccountsByPasswordEquals" })
public class UserAccount implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario", nullable = false,unique=true)
    private Funcionario idFuncionario;

    

    
    
    @NotNull
    @Column(name="userName", unique=true)
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    @Size(max = 1)
    private String enabled;

    @ManyToOne
    private UserRole userRole;
    
 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateCreation;
    

//    @ManyToOne
//    @JoinColumn(name = "user_role", referencedColumnName = "id")
//    private UserRole userRole;


    
    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



	
//	 public static TypedQuery<UserAccount> findUserAccountsByUserNameEquals(String userName) {
//	        if (userName == null || userName.length() == 0) throw new IllegalArgumentException("The userName argument is required");
//	        EntityManager em = UserAccount.entityManager();
//	        TypedQuery<UserAccount> q = em.createQuery("SELECT o FROM UserAccount AS o WHERE o.userName = :userName", UserAccount.class);
//	        q.setParameter("userName", userName);
//	        return q;
//	    }
//	
    
    
}
