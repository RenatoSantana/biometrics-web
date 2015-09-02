package br.gov.sspba.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Cutis;
import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Sexo;
import br.gov.sspba.domain.UserAccount;
import br.gov.sspba.domain.UserRole;
import br.gov.sspba.service.ServiceGlobalSession;
import br.gov.sspba.util.JsfUtils;




@Component
@Scope(value="view")
public class AccountBean implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// =========================================================================
    // Atributos
    // =========================================================================
	private UserAccount user;
	private UserAccount userSelected;
	private List<UserAccount> userList;
	private List<UserAccount> userListSelected;
	private long role;
	
	private Funcionario funcionario;
	
	 // =========================================================================
    // Construtores
    // =========================================================================
 
	public AccountBean() {
		try {
			refreshList();
//			RequestContext context = RequestContext.getCurrentInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	// =========================================================================
    // Metodos
    // =========================================================================
	
	public void refreshList(){
		
		user = new UserAccount();
		role = 0;
		user.setEnabled("1");
		userSelected = new UserAccount();
		userList = new ArrayList<UserAccount>();
		userListSelected = new ArrayList<UserAccount>();
		userList.addAll(UserAccount.findAllUserAccounts());
		userListSelected.addAll(UserAccount.findAllUserAccounts());

		funcionario=(Funcionario) JsfUtils.getObjectSession("funcionario_usuario");
		if(funcionario==null){
		    funcionario = new Funcionario();
			
		}else{
			user.setFirstName(funcionario.getNome());
			user.setLastName(funcionario.getSobrenome());
			//
			
		}
		
	
		
	}
	
	public List<UserAccount> getAllAccounts(){
		return UserAccount.findAllUserAccounts();
	}
	
	public List<UserRole> getAllRoles(){
		return UserRole.findAllUserRoles();
	}
	
	
	public void selecionaRegra(SelectEvent event) {  
		user.getUserRole().setId((Long)event.getObject());;
		
				
	}
	
	
	public  static List<UserRole> autoCompleteRegra(String query) {  
		List<UserRole> suggestions = new ArrayList<UserRole>();  
		List<UserRole> regraList = UserRole.findAllUserRoles();
		if(query.length()>=3){
			for(UserRole s : regraList) {  
				if(s.getRoleName() .toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(s);  
			}  
		}else if(query.length()==0){
			suggestions = regraList;
		}

		return suggestions;  
	}  
	public void save(){
		try {
			user.setDateCreation(new Date());
			user.setIdFuncionario(funcionario);
			user.setUserName(funcionario.getMatricula());
			user.setFirstName(funcionario.getNome());
			user.setLastName(funcionario.getSobrenome());
			user.setPassword("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
			user.setUserRole(UserRole.findUserRole(role));
			user.persist();
			user = new UserAccount();
			role =0;
			funcionario= new Funcionario();
			JsfUtils.setObjectSession("funcionario_usuario", null);
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Nova Conta Criada");
			
			FacesMessage msg = null;  
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Nova Conta Criada"); 
			
			FacesContext.getCurrentInstance().addMessage(null, msg);  
			refreshList();
			
			
		}
		catch (Exception e) {
			
			if(e.getCause().getCause() instanceof org.hibernate.exception.ConstraintViolationException){
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro enquanto persitet : {}",e);
				FacesMessage msg = null;  
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Este funcionário já é um usuário do sistema");  
				FacesContext.getCurrentInstance().addMessage(null, msg);  
			}else{
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro enquanto persitet : {}",e);
					FacesMessage msg = null;  
					msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Um erro ocorreu criação do usuário");  
					FacesContext.getCurrentInstance().addMessage(null, msg);  
			
			}
		}
	}
	
	public void  updatePassword(ActionEvent event){
		try{
		    UserAccount userAccount = (UserAccount) JsfUtils.getObjectSession("loggedUser");
		    userAccount.setPassword(user.getPassword());
		    userAccount.merge();
			refreshList();
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Senha Atualizada");

			FacesMessage msg = null;  
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Senha Atualizada");  
			FacesContext.getCurrentInstance().addMessage(null, msg);  

			}catch(Exception e){
				e.printStackTrace();
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro na atualização : {}",e);
				FacesMessage msg = null;  
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificação", "Um erro ocorreu na atualização");  
				FacesContext.getCurrentInstance().addMessage(null, msg);  
			}
	}
	public void update(ActionEvent event){
		try{
	    userSelected.setUserRole(UserRole.findUserRole(role));
		userSelected.merge();
		refreshList();
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Conta Atualizada");

		FacesMessage msg = null;  
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Conta Atualizada");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  

		}catch(Exception e){
			e.printStackTrace();
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro na atualização : {}",e);
			FacesMessage msg = null;  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Notificação", "Um erro ocorreu na atualização");  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
	}
	
	public void delete(ActionEvent event){
		try{
			
			userSelected.remove();
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Conta Removida");
			refreshList();
	        FacesMessage msg = null;  
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Sucesso");  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
			
		}catch(Exception e){
			 e.printStackTrace();
			 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro durantea a remoção : {}",e);
				FacesMessage msg = null;  
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Um erro ocorreu");  
				FacesContext.getCurrentInstance().addMessage(null, msg);  
		}
	}
	
	
	
	
	public void onCancel(RowEditEvent event) {  
		refreshList();
        FacesMessage msg = new FacesMessage("Notificação", "null");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void reset() {  
		refreshList();
        RequestContext.getCurrentInstance().reset("form1:panel");  
    }  
	
	
	
	
	
	 // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
	
	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public UserAccount getUserSelected() {
		if(userSelected.getId() != null ){
			role = userSelected.getUserRole().getId();
		}
		return userSelected;
	}

	public void setUserSelected(UserAccount userSelected) {
		this.userSelected = userSelected;
	}

	public List<UserAccount> getUserList() {
		return userList;
	}

	public void setUserList(List<UserAccount> userList) {
		this.userList = userList;
	}

	public List<UserAccount> getUserListSelected() {
		return userListSelected;
	}

	public void setUserListSelected(List<UserAccount> userListSelected) {
		this.userListSelected = userListSelected;
	}



	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	
	

}
