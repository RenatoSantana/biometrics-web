package br.gov.sspba.security;

import java.io.IOException;
import java.util.Collection;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.UserAccount;
import br.gov.sspba.service.FuncionarioService;
import br.gov.sspba.service.UserAccountService;
import br.gov.sspba.util.JsfUtils;


@Component
@Scope
public class LoginController {

	/**
	 * 
	 */

	protected final Log logger = LogFactory.getLog(getClass());
	private UserAccount loggedUser;
	

	
	public String doLogin() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/resources/j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
		
    }
	
	
	
	
	public String doLogout() throws ServletException, IOException {
		SecurityContextHolder.getContext().setAuthentication(null);
		JsfUtils.setObjectSession("loggedUser",null);
		
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                        .clear();
        return "/login?faces-redirect=true";
		
    }





	public UserAccount getLoggedUser() {
	//	Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		loggedUser =(UserAccount)JsfUtils.getObjectSession("loggedUser");
		
		if(loggedUser==null){
			loggedUser=UserAccountService.findUserAccountsByUserNameEquals(SecurityContextHolder.getContext().getAuthentication().getName());	
	
			
			JsfUtils.setObjectSession("loggedUser",loggedUser);
			
		}
			
		return loggedUser;
	}




	public void setLoggedUser(UserAccount loggedUser) {
		this.loggedUser = loggedUser;
	}









	
	



}
