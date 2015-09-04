package br.gov.sspba.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Comando;
import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Municipio;
import br.gov.sspba.domain.Regiao;
import br.gov.sspba.domain.Unidade;
import br.gov.sspba.domain.UserAccount;
import br.gov.sspba.util.JsfUtils;
@Component
@Scope(value = "view")
public class UnidadeBean extends BaseBean implements BeanImpl,Serializable {
	
	private Unidade unidade;
	
	private List<Unidade> unidadeList;
	
	private List<Unidade> unidadeSelectedList;
	
	public UnidadeBean(){
		refreshList();
	}

	@Override
	public void refreshList() {
		// TODO Auto-generated method stub
		

		
		
		unidade=(Unidade) JsfUtils.getObjectSession("unidade");
		if(unidade==null){
			unidade = new Unidade();
			
		}
		
		unidadeList = new ArrayList<Unidade>();
	
		unidadeList.addAll(Unidade.findAllUnidades());
		
	}
	
	
	public void selecionaUnidade(Unidade unidade){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

		JsfUtils.setObjectSession("unidade", unidade);

		try {
			context.getExternalContext().redirect(request.getContextPath() + "/module/unidade/new.xhtml");

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   
	}

	
	public void selecionaMunicipio(SelectEvent event) {  
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		unidade.setIdMunicipio((Municipio)event.getObject()); 
				
	}
	
	public void selecionaComando(SelectEvent event) {  
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		unidade.setIdComando((Comando)event.getObject()); 
				
	}
	
	public void selecionaRegiao(SelectEvent event) {  
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		unidade.setIdRegiao((Regiao)event.getObject()); 
				
	}
	@Override
	public void save() {
	
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		try {
			  if(unidade.getIdUnidade()==null)
			    {
				  
					unidade.persist();
					unidade = new Unidade();
					Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Nova Unidade adicionada");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Cadastro efetuado com sucesso");
					FacesContext.getCurrentInstance().addMessage(null, msg);  
					
					try {

						context.getExternalContext().redirect(request.getContextPath() + "/module/unidade/all.xhtml");
					} catch (IOException ex) {

						context.addMessage(null, new FacesMessage(":(", "Um erro ocorreu!"));
					}
				
			    }
			    else  if(unidade.getIdUnidade()!=null){
			    	unidade.merge();
					unidade = new Unidade();
					JsfUtils.setObjectSession("unidade",null);
					Logger.getLogger(this.getClass().getName()).log(Level.INFO, " Nova Unidade Atualizada");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Cadastro atualizado com sucesso");
					FacesContext.getCurrentInstance().addMessage(null, msg); 
					try {

						context.getExternalContext().redirect(request.getContextPath() + "/module/unidade/all.xhtml");
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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Unidade> getUnidadeList() {
		return unidadeList;
	}

	public void setUnidadeList(List<Unidade> unidadeList) {
		this.unidadeList = unidadeList;
	}

	public List<Unidade> getUnidadeSelectedList() {
		return unidadeSelectedList;
	}

	public void setUnidadeSelectedList(List<Unidade> unidadeSelectedList) {
		this.unidadeSelectedList = unidadeSelectedList;
	}

	
}
