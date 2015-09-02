package br.gov.sspba.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope
public class UserBean {

	/**
	 * 
	 */
	private String username;
	private String password;
	private String email;
	private boolean loggedIn = false;  
    private boolean rememberMe = false;

	public UserBean(){
		
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	 public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	public boolean isRememberMe() {
		return rememberMe;
	}


	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}



}
