package br.gov.sspba.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Dadobiometrico;
import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Notageral;
import br.gov.sspba.domain.UserAccount;
import br.gov.sspba.service.DadoBiometricoService;
import br.gov.sspba.service.NotaGeralService;
import br.gov.sspba.util.JsfUtils;



@Component
@Scope(value="view")
public class NotaGeralBean implements BeanImpl,Serializable {

	
	private List<Notageral> notasGerais;
	
	private Notageral notaGeral;
	
	private Funcionario funcionario;
	
	private boolean podeSalvar;
	
	public NotaGeralBean(){
		refreshList();
	}

	public List<Notageral> getNotasGerais() {
		return notasGerais;
	}

	public void setNotasGerais(List<Notageral> notasGerais) {
		this.notasGerais = notasGerais;
	}

	public Notageral getNotaGeral() {
		return notaGeral;
	}

	public void setNotaGeral(Notageral notaGeral) {
		this.notaGeral = notaGeral;
	}

	@Override
	public void refreshList() {
		 podeSalvar = true;
		 notaGeral = new Notageral();
		 funcionario =(Funcionario) JsfUtils.getObjectSession("funcionario");
		 try{
			 notasGerais = NotaGeralService.findNotaGeralByFilter(funcionario);
		 } catch (EmptyResultDataAccessException nre){
			 notasGerais = new ArrayList<Notageral>();
		 }
		

		
	
		 
	}

	
	
	public void adicionarNotaGeral(ActionEvent e){

		if(funcionario!=null){
			   
			
			    UserAccount user =(UserAccount)JsfUtils.getObjectSession("loggedUser");
			    
      			notaGeral.setUserId(user);
  				notaGeral.setIdFuncionario(funcionario);
  				notaGeral.setDataRegistro(new Date());
  				notaGeral.persist();
  				
  				if(notaGeral!=null && notaGeral.getIdNotaGeral()!=null){
  					//notasGerais.add(notaGeral);
  					notasGerais = NotaGeralService.findNotaGeralByFilter(funcionario);
  					 podeSalvar = false;
  				}
		
			
			    notaGeral = new Notageral();
		}
		

	  
	}
	
	public String voltar(){
		 return "/module/funcionario/new.xhtml";
	}


	
	
	
	@Override
	public void save() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			  if(funcionario.getIdFuncionario()==null)
			    {
				    String matricula = (String) JsfUtils.getObjectSession("funcionario_matricula");
					Dadobiometrico dado =  DadoBiometricoService.findDadoBiometricoByMatricula(matricula);
					funcionario.setIdDadoBiometrico(dado);
					
					funcionario.setVia(0);
					funcionario.setIdDadoBiometrico(dado);
					funcionario.persist();
					funcionario = new Funcionario();
					Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Novo Funcionário adicionado");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Cadastro efetuado com sucesso");
					FacesContext.getCurrentInstance().addMessage(null, msg);  
					
					try {

						context.getExternalContext().redirect(request.getContextPath() + "/module/funcionario/all.xhtml");
					} catch (IOException ex) {

						context.addMessage(null, new FacesMessage(":(", "Um erro ocorreu!"));
					}
				
			    }
			    else if(funcionario.getIdFuncionario()!=null){
			    	funcionario.merge();
					funcionario = new Funcionario();
					Logger.getLogger(this.getClass().getName()).log(Level.INFO, " Funcionário Atualizado");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Cadastro atualizado com sucesso");
					FacesContext.getCurrentInstance().addMessage(null, msg); 
					try {

						context.getExternalContext().redirect(request.getContextPath() + "/module/funcionario/all.xhtml");
					} catch (IOException ex) {

						context.addMessage(null, new FacesMessage(":(", "Um erro ocorreu!"));
					}
				
			    }
				} catch (Exception e) {
					Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Erro enquanto persiste : {}",e);
					FacesMessage msg = null;  
					msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Notificação", "Ocorreu um erro ao criar/atualizar funcionário");  
					FacesContext.getCurrentInstance().addMessage(null, msg);  
				}
				
		
	}

	
	
	
	@Override
	public void update(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancel(RowEditEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isPodeSalvar() {
		return podeSalvar;
	}

	public void setPodeSalvar(boolean podeSalvar) {
		this.podeSalvar = podeSalvar;
	}
	
	
	
	
	
}
