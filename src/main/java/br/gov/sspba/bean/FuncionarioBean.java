package br.gov.sspba.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Bairro;
import br.gov.sspba.domain.Barba;
import br.gov.sspba.domain.Bigode;
import br.gov.sspba.domain.Cabelo;
import br.gov.sspba.domain.CategoriaCNH;
import br.gov.sspba.domain.Cutis;
import br.gov.sspba.domain.Dadobiometrico;
import br.gov.sspba.domain.Estado;
import br.gov.sspba.domain.Estadocivil;
import br.gov.sspba.domain.Fatorrh;
import br.gov.sspba.domain.Funcionario;
import br.gov.sspba.domain.Graudeinstrucao;
import br.gov.sspba.domain.Gruposanguineo;
import br.gov.sspba.domain.Municipio;
import br.gov.sspba.domain.Notaanomala;
import br.gov.sspba.domain.Olho;
import br.gov.sspba.domain.Postograduacao;
import br.gov.sspba.domain.Quadro;
import br.gov.sspba.domain.Sexo;
import br.gov.sspba.domain.Situacaopolicial;
import br.gov.sspba.domain.Tipocertidao;
import br.gov.sspba.domain.Unidade;
import br.gov.sspba.domain.UserAccount;
import br.gov.sspba.security.CheckRole;
import br.gov.sspba.service.FuncionarioService;
import br.gov.sspba.service.ServiceSession;
import br.gov.sspba.util.Constants;
import br.gov.sspba.util.JsfUtils;

@Component
@Scope(value = "view")
public class FuncionarioBean extends BaseBean implements BeanImpl,Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Municipio> municipioList;
	private List<Funcionario> funcionarioList;
	private Funcionario funcionario;
	private Funcionario funcionarioSelecionado;
	private String matricula;
	private String cpf;
	private String nome;
	
	private boolean autExpeditora;
	
	private String sobrenome;
	private Estado estado;
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public FuncionarioBean(){
		refreshList();
	}
	
	@Override
	public void refreshList() {
		funcionario=(Funcionario) JsfUtils.getObjectSession("funcionario");
		if(funcionario==null){
		    funcionario = new Funcionario();
			
		}
		funcionarioSelecionado= new Funcionario();
		
	}
	
	
	public List<Municipio> autoCompleteMunicipiosByEstado(String query) {  

		List<Municipio> suggestions = new ArrayList<Municipio>(); 
		if(estado!=null && estado.getIdEstado()!=null)	{
		List<Municipio> list = ServiceSession.findAllMunicipiosByEstado(estado);
		if(query.length()>=3){
			for(Municipio p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}
		}
		return suggestions;  
	}  
	
	public List<Bairro> autoCompleteBairroByMunicipio(String query) {  

		List<Bairro> suggestions = new ArrayList<Bairro>(); 
	if(funcionario.getIdMunicipioResidente()!=null && funcionario.getIdMunicipioResidente().getIdMunicipio()!=null)	{
		List<Bairro> list = ServiceSession.findAllBairroByMunicipio(funcionario.getIdMunicipioResidente());
		if(query.length()>=3){
			for(Bairro p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}
	}

	return suggestions;  
	}  
	public void  avancar(ActionEvent e) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
		JsfUtils.setObjectSession("funcionario", funcionario);
		
		try {

			context.getExternalContext().redirect(request.getContextPath() + "/module/notas/geral.xhtml");
		} catch (IOException ex) {

			context.addMessage(null, new FacesMessage(":(", "Um erro ocorreu!"));
		}
	

		
	}

	@Override
	public void save() {
	
	}
	
	
	public void definirAutoridadeExpeditora(ActionEvent event){
		
		if(funcionarioSelecionado!=null && funcionarioSelecionado.getAutExpeditora()==true){
			  funcionarioSelecionado.setEnabledAutExpeditora(Constants.AUT_EXPEDITORA);
		      funcionarioSelecionado.setAutExpeditora(true);
		}else if(funcionarioSelecionado!=null && funcionarioSelecionado.getAutExpeditora()==false){
			 funcionarioSelecionado.setEnabledAutExpeditora(null);
		      funcionarioSelecionado.setAutExpeditora(false);
		}
        try{
        	funcionarioSelecionado.merge();
        	funcionarioSelecionado = new Funcionario();
        }catch(org.hibernate.exception.ConstraintViolationException ex){
        	addMessage("Notificação","Já existe um usuário como autoridade Expeditora");
        }catch(org.springframework.orm.jpa.JpaSystemException ex){
           	addMessage("Notificação","Já existe um usuário como autoridade Expeditora");
        }catch (Exception e){
        	addMessage("Notificação","Um erro ocorreu ");
        }
	   
    }
	
	
	
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public void selecionaFuncionario(Funcionario funcionario ){
		   FacesContext context = FacesContext.getCurrentInstance();
	       HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	       
		   JsfUtils.setObjectSession("funcionario", funcionario);
		   
		  try {
			  if(new CheckRole().hasRole("USER")){
				 UserAccount user = (UserAccount)JsfUtils.getObjectSession("loggedUser");
				 Funcionario funcionarioSession =user.getIdFuncionario();
			
				 if(funcionarioSession==null && funcionario!=null){
					 context.getExternalContext().redirect(request.getContextPath() + "/ops.xhtml");
				 }else if(funcionarioSession.getIdUnidade()!=null && funcionarioSession.getIdUnidade().getIdComando()!=null){
					 if(!funcionarioSession.getIdUnidade().getIdComando().equals(funcionario.getIdUnidade().getIdComando())){
						 context.getExternalContext().redirect(request.getContextPath() + "/ops.xhtml");
					 }else{
				
						 context.getExternalContext().redirect(request.getContextPath() + "/module/funcionario/new.xhtml");
					 }
					 
				 }
			 
		    }else if(new CheckRole().hasRole("ADMIN")){
		    	 context.getExternalContext().redirect(request.getContextPath() + "/module/funcionario/new.xhtml");
		    }
				
			 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void selecionaFuncionarioParaContaUsuario(Funcionario funcionario ){
		 FacesContext context = FacesContext.getCurrentInstance();
	       HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	       
		   JsfUtils.setObjectSession("funcionario_usuario", funcionario);
		   
		  try {
				context.getExternalContext().redirect(request.getContextPath() + "/module/usuario/new.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void findFuncionarioByFilter(ActionEvent event) {
		try{

			funcionarioList= FuncionarioService.findFuncionarioByFilter(matricula,cpf, nome, sobrenome,autExpeditora);

			
			if(funcionarioList == null && funcionarioList.size()==0){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Nenhum registro encontrado");
				FacesContext.getCurrentInstance().addMessage(null, msg);  
			}

		} catch (EmptyResultDataAccessException nre)
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Nenhum registro encontrado");
			FacesContext.getCurrentInstance().addMessage(null, msg);  

		}



	}

	public String findFuncionarioByMatricula(){
		Dadobiometrico dado=null;
		 try{
			
	         dado= Dadobiometrico.findDadoBiometricoByMatricula(matricula).getSingleResult();
			 funcionario= FuncionarioService.findFuncionarioByMatricula(matricula);
			 
			 
			 
			 
			 if(new CheckRole().hasRole("USER")){
				 UserAccount user = (UserAccount)JsfUtils.getObjectSession("loggedUser");
				 Funcionario funcionarioSession =user.getIdFuncionario();
			
				 if(funcionarioSession==null && funcionario!=null){
						return "/error.xhtml";
					
				 }else if(funcionarioSession.getIdUnidade()!=null && funcionarioSession.getIdUnidade().getIdComando()!=null){
					 if(!funcionarioSession.getIdUnidade().getIdComando().equals(funcionario.getIdUnidade().getIdComando())){
						 return "/ops.xhtml";
					 }else{
				
						 JsfUtils.setObjectSession("funcionario", funcionario);
						 JsfUtils.setObjectSession("funcionario_matricula", matricula);
						 return "/module/funcionario/new.xhtml";
					 }
					 
				 }
			 
		    }else if(new CheckRole().hasRole("ADMIN")){
		    	 JsfUtils.setObjectSession("funcionario", funcionario);
				 JsfUtils.setObjectSession("funcionario_matricula", matricula);
		    	return "/module/funcionario/new.xhtml";
		    }
				
			 
			
		 } catch (EmptyResultDataAccessException nre)
		 {
				//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificação", "Nenhum registro encontrado");
				//F//acesContext.getCurrentInstance().addMessage(null, msg);  
				funcionario =null;
				JsfUtils.setObjectSession("funcionario", funcionario);
				if(dado==null){
					return "/notificacao.xhtml";
				}else{
					return "/module/funcionario/new.xhtml";
				}
				
	     }
		 
		 return "/";
	}
	
	public List<Sexo> autoCompleteSexo2(String query){
		return BaseBean.autoCompleteSexo(query);
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
	
	public void selecionaBairro(SelectEvent event) {  
		funcionario.setIdBairroResidente(((Bairro)event.getObject())); 
				
	}
	
	public void selecionaCategoriaCNH(SelectEvent event) {  
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		funcionario.setIdCategoriaCNH((CategoriaCNH)event.getObject()); 
				
	}
	public void selecionaMunicipio(SelectEvent event) {  
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		funcionario.setIdMunicipioResidente((Municipio)event.getObject()); 
				
	}
	
	public void selecionaSexo(SelectEvent event) {  
		 
		funcionario.setIdSexo((Sexo)event.getObject()); 
	}
	
	
	
	public void selecionaSituacaoPolicial(SelectEvent event) {  
		funcionario.setIdSituacaoPolicial((Situacaopolicial)event.getObject()); 


				
	}
	
	public void selecionaUnidade(SelectEvent event) {  
		funcionario.setIdUnidade((Unidade)event.getObject()); 
				
	}
	
	public void selecionaEstadoCivil(SelectEvent event) {  
		funcionario.setIdEstadoCivil((Estadocivil)event.getObject()); 
				
	}
	
	public void selecionaGrauInstrucao(SelectEvent event) {  
		funcionario.setIdGrauDeInstrucao((Graudeinstrucao)event.getObject()); 

				
	}
	
	public void selecionaCutis(SelectEvent event) {  
		funcionario.setIdCutis((Cutis)event.getObject()); 
				
	}
	
	public void selecionaCabelo(SelectEvent event) {  
		funcionario.setIdCabelo((Cabelo)event.getObject()); 

				
	}

	public void selecionaBarba(SelectEvent event) {  
		funcionario.setIdBarba((Barba)event.getObject()); 

				
	}
	
	public void selecionaBigode(SelectEvent event) {  
		funcionario.setIdBigode((Bigode)event.getObject()); 		
	}
	
	public void selecionaOlho(SelectEvent event) {  
		funcionario.setIdOlho((Olho)event.getObject()); 	
				
	}
	
	public void selecionaGrupoSanguineo(SelectEvent event) {  
		funcionario.setIdGrupoSanguineo((Gruposanguineo)event.getObject()); 	
	}
	public void selecionaFatorRH(SelectEvent event) {  
	
		funcionario.setIdFatorRh((Fatorrh)event.getObject()); 				
	}
	
	public void selecionaTipoLogradouro(SelectEvent event) {  
	//	endereco.s
				
	}
	
	
	
	
	public void selecionaTipoCertidao(SelectEvent event) {  
		funcionario.setIdTipoCertidao((Tipocertidao)event.getObject()); 				
				
	}
	
	public void selecionaEstado(SelectEvent event) {  
		estado = ((Estado)event.getObject());
		
	}
	
	
	public void selecionaPostoGraduacao(SelectEvent event) {  
		funcionario.setIdPostoGraduacao((Postograduacao)event.getObject()); 				
				
	}
	
	
	public void selecionaQuadro(SelectEvent event) {  
		funcionario.setIdQuadro((Quadro)event.getObject()); 		

				
	}
	
	public void selecionaNotaAnomala(SelectEvent event) {  
		funcionario.setIdNotaAnomala((Notaanomala)event.getObject()); 	
				
	}
	
	
	
	public List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarioList() {
		return funcionarioList;
	}

	public void setFuncionarioList(List<Funcionario> funcionarioList) {
		this.funcionarioList = funcionarioList;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public boolean isAutExpeditora() {
		return autExpeditora;
	}

	public void setAutExpeditora(boolean autExpeditora) {
		this.autExpeditora = autExpeditora;
	}

			
			
			

}
