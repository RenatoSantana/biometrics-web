package br.gov.sspba.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Barba;
import br.gov.sspba.domain.Bigode;
import br.gov.sspba.domain.Cabelo;
import br.gov.sspba.domain.CategoriaCNH;
import br.gov.sspba.domain.Cutis;
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
import br.gov.sspba.domain.UserRole;
import br.gov.sspba.security.CheckRole;
import br.gov.sspba.security.LoginController;
import br.gov.sspba.util.JsfUtils;

@Component
@Scope(value = "globalSession")
public class ServiceGlobalSession {

	private static List<Barba> barbaList;
	
	private static List<Bigode> bigodeList;
	
	private static List<Cabelo> cabeloList;
	
	private static List<Cutis> cutisList;
	
	private static List<Estadocivil> estadoCivilList;
	
	private static List<Estado> estadoList;
	
	private static List<Fatorrh> fatorRHList;
	
	private static List<Graudeinstrucao> grauInstrucaoList;
	
	private static List<Gruposanguineo> grupoSanguineoList;
	
	private static List<Municipio> municipioList;
	
	private static List<Notaanomala> notaAnomalaList;
	
	private static List<Olho> olhoList;
	
	private static List<Postograduacao> postoGraduacaoList;
	
	private static List<Quadro> quadroList;
	
	private static List<Sexo> sexoList;
	
	private static List<Situacaopolicial> situacaoPolicialList;
	
	private static List<Tipocertidao> tipoCertidaoList;
	
	private static List<Unidade> unidadeList;
	
	private static List<UserRole> regraList;
	
	private static List<CategoriaCNH> categoriaCNHList;
	
	
	public static List<CategoriaCNH> findAllCategoriaCNH(){

		if(categoriaCNHList==null)
			return categoriaCNHList = CategoriaCNH.findAllCategoriaCNHs();
		else
			return categoriaCNHList;
	}

	
	public static List<Barba> findAllBarba(){

		if(barbaList==null)
			return barbaList = Barba.findAllBarbas();
		else
			return barbaList;
	}

	public static List<Bigode> findAllBigode(){

		if(bigodeList==null)
			return bigodeList = Bigode.findAllBigodes();
		else
			return bigodeList;
	}

	
	public static List<Cabelo> findAllCabelo(){

		if(cabeloList==null)
			return cabeloList = Cabelo.findAllCabeloes();
		else
			return cabeloList;
	}

	
	public static List<Cutis> findAllCutis(){

		if(cutisList==null)
			return cutisList = Cutis.findAllCutises();
		else
			return cutisList;
	}
	
	public static List<Estadocivil> findAllEstadoCivil(){

		if(estadoCivilList==null)
			return estadoCivilList = Estadocivil.findAllEstadocivils();
		else
			return estadoCivilList;
	}
	
	public static List<Estado> findAllEstado(){

		if(estadoList==null)
			return estadoList = Estado.findAllEstadoes();
		else
			return estadoList;
	}
	
	public static List<Fatorrh> findAllFatorRH(){

		if(fatorRHList==null)
			return fatorRHList = Fatorrh.findAllFatorrhs();
		else
			return fatorRHList;
	}
	
	
	public static List<Graudeinstrucao> findAllGrauInstrucao(){

		if(grauInstrucaoList==null)
			return grauInstrucaoList = Graudeinstrucao.findAllGraudeinstrucaos();
		else
			return grauInstrucaoList;
	}
	
	public static List<Gruposanguineo> findAllGrupoSanguineo(){

		if(grupoSanguineoList==null)
			return grupoSanguineoList = Gruposanguineo.findAllGruposanguineos();
		else
			return grupoSanguineoList;
	}
	
	
	public static List<Municipio> findAllMunicipio(){

		if(municipioList==null)
			return municipioList = Municipio.findAllMunicipios();
		else
			return municipioList;
	}
	
	public static List<Notaanomala> findAllNotaAnomala(){

		if(notaAnomalaList==null)
			return notaAnomalaList = Notaanomala.findAllNotaanomalas();
		else
			return notaAnomalaList;
	}
	
	public static List<Olho> findAllOlho(){

		if(olhoList==null)
			return olhoList = Olho.findAllOlhoes();
		else
			return olhoList;
	}
	
	public static List<Postograduacao> findAllPostoGraduacao(){

		if(postoGraduacaoList==null)
			return postoGraduacaoList = Postograduacao.findAllPostograduacaos();
		else
			return postoGraduacaoList;
	}
	
	public static List<Quadro> findAllQuadro(){

		if(quadroList==null)
			return quadroList = Quadro.findAllQuadroes();
		else
			return quadroList;
	}
	
	public static List<Sexo> findAllSexo(){
		
		if(sexoList==null)
			return sexoList = Sexo.findAllSexoes();
		else
			return sexoList;
	}

    public static List<Situacaopolicial> findAllSituacaoPolicial(){
		
		if(situacaoPolicialList==null)
			return situacaoPolicialList = Situacaopolicial.findAllSituacaopolicials();
		else
			return situacaoPolicialList;
	}
    
    
    public static List<Tipocertidao> findAllTipoCertidao(){
		
		if(tipoCertidaoList==null)
			return tipoCertidaoList = Tipocertidao.findAllTipocertidaos();
		else
			return tipoCertidaoList;
	}

    
   public static List<Unidade> findAllUnidade(){
		
		
	   if(unidadeList==null){
		   if(new CheckRole().hasRole("USER")){
			   UserAccount user = (UserAccount)JsfUtils.getObjectSession("loggedUser");
			   Funcionario funcionarioSession =user.getIdFuncionario();
			   unidadeList= Unidade.findUnidadesByIdComandoEquals(funcionarioSession.getIdUnidade().getIdComando()).getResultList();
		   } if(new CheckRole().hasRole("ADMIN")){
		         return unidadeList = Unidade.findAllUnidades();
		   }
		}else{
			return unidadeList;
		}
	   
	   return unidadeList;
	}
	public static List<Sexo> getSexoList() {
		return sexoList;
	}
	
	
	public static List<UserRole> findAllUserRole(){

		if(regraList==null)
			return regraList = UserRole.findAllUserRoles();
		else
			return regraList;
	}

	public static void setSexoList(List<Sexo> sexoList) {
		ServiceGlobalSession.sexoList = sexoList;
	}

	public static List<CategoriaCNH> getCategoriaCNHList() {
		return categoriaCNHList;
	}

	public static void setCategoriaCNHList(List<CategoriaCNH> categoriaCNHList) {
		ServiceGlobalSession.categoriaCNHList = categoriaCNHList;
	}

}
