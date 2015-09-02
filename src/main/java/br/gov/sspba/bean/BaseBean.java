package br.gov.sspba.bean;

import java.util.ArrayList;
import java.util.List;

import br.gov.sspba.domain.Barba;
import br.gov.sspba.domain.Bigode;
import br.gov.sspba.domain.Cabelo;
import br.gov.sspba.domain.CategoriaCNH;
import br.gov.sspba.domain.Cutis;
import br.gov.sspba.domain.Estado;
import br.gov.sspba.domain.Estadocivil;
import br.gov.sspba.domain.Fatorrh;
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
import br.gov.sspba.service.ServiceGlobalSession;

public class BaseBean {


	
	public  static List<Sexo> autoCompleteSexo(String query) {  
		List<Sexo> suggestions = new ArrayList<Sexo>();  
		List<Sexo> sexoList = ServiceGlobalSession.findAllSexo();
		if(query.length()>=3){
			for(Sexo s : sexoList) {  
				if(s.getDescricao() .toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(s);  
			}  
		}else if(query.length()==0){
			suggestions = sexoList;
		}

		return suggestions;  
	}  
	
	
	public  static List<CategoriaCNH> autoCompleteCategoriaCNH(String query) {  
		List<CategoriaCNH> suggestions = new ArrayList<CategoriaCNH>();  
		List<CategoriaCNH> list = ServiceGlobalSession.findAllCategoriaCNH();
		if(query.length()>=1){
			for(CategoriaCNH s : list) {  
				if(s.getDescricao() .toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(s);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public  static List<Estado> autoCompleteEstado(String query) {  
		List<Estado> suggestions = new ArrayList<Estado>();  
		List<Estado> list = ServiceGlobalSession.findAllEstado();
		if(query.length()>=3){
			for(Estado s : list) {  
				if(s.getDescricao() .toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(s);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	} 
	
	
	public List<Municipio> autoCompleteMunicipio(String query) {  

		List<Municipio> suggestions = new ArrayList<Municipio>(); 
		List<Municipio> list = ServiceGlobalSession.findAllMunicipio();
		if(query.length()>=3){
			for(Municipio p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}
		return suggestions;  
	}  
	
	
	public List<Situacaopolicial> autoCompleteSituacaoPolicial(String query) {  

		List<Situacaopolicial> suggestions = new ArrayList<Situacaopolicial>(); 
		List<Situacaopolicial> list = ServiceGlobalSession.findAllSituacaoPolicial();
		if(query.length()>=3){
			for(Situacaopolicial p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Unidade> autoCompleteUnidade(String query) {  

		List<Unidade> suggestions = new ArrayList<Unidade>(); 
		List<Unidade> list = ServiceGlobalSession.findAllUnidade();
		if(query.length()>=3){
			for(Unidade p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Estadocivil> autoCompleteEstadoCivil(String query) {  

		List<Estadocivil> suggestions = new ArrayList<Estadocivil>(); 
		List<Estadocivil> list = ServiceGlobalSession.findAllEstadoCivil();
		if(query.length()>=3){
			for(Estadocivil p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Graudeinstrucao> autoCompleteGrauInstrucao(String query) {  

		List<Graudeinstrucao> suggestions = new ArrayList<Graudeinstrucao>(); 
		List<Graudeinstrucao> list = ServiceGlobalSession.findAllGrauInstrucao();
		if(query.length()>=3){
			for(Graudeinstrucao p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Cutis> autoCompleteCutis(String query) {  

		List<Cutis> suggestions = new ArrayList<Cutis>(); 
		List<Cutis> list = ServiceGlobalSession.findAllCutis();
		if(query.length()>=3){
			for(Cutis p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Cabelo> autoCompleteCabelo(String query) {  

		List<Cabelo> suggestions = new ArrayList<Cabelo>(); 
		List<Cabelo> list = ServiceGlobalSession.findAllCabelo();
		if(query.length()>=3){
			for(Cabelo p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	} 
	
	
	public List<Barba> autoCompleteBarba(String query) {  

		List<Barba> suggestions = new ArrayList<Barba>(); 
		List<Barba> list = ServiceGlobalSession.findAllBarba();
		if(query.length()>=3){
			for(Barba p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	public List<Bigode> autoCompleteBigode(String query) {  

		List<Bigode> suggestions = new ArrayList<Bigode>(); 
		List<Bigode> list = ServiceGlobalSession.findAllBigode();
		if(query.length()>=3){
			for(Bigode p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Olho> autoCompleteOlho(String query) {  

		List<Olho> suggestions = new ArrayList<Olho>(); 
		List<Olho> list = ServiceGlobalSession.findAllOlho();
		if(query.length()>=3){
			for(Olho p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	

	

	public List<Gruposanguineo> autoCompleteGrupoSanguineo(String query) {  

		List<Gruposanguineo> suggestions = new ArrayList<Gruposanguineo>(); 
		List<Gruposanguineo> list = ServiceGlobalSession.findAllGrupoSanguineo();
		if(query.length()>=3){
			for(Gruposanguineo p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	public List<Fatorrh> autoCompleteFatorRH(String query) {  

		List<Fatorrh> suggestions = new ArrayList<Fatorrh>(); 
		List<Fatorrh> list = ServiceGlobalSession.findAllFatorRH();
		if(query.length()>=3){
			for(Fatorrh p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	
	
	public List<Tipocertidao> autoCompleteTipoCertidao(String query) {  

		List<Tipocertidao> suggestions = new ArrayList<Tipocertidao>(); 
		List<Tipocertidao> list = ServiceGlobalSession.findAllTipoCertidao();
		if(query.length()>=3){
			for(Tipocertidao p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
	
	
	public List<Postograduacao> autoCompletePostoGraduacao(String query) {  

		List<Postograduacao> suggestions = new ArrayList<Postograduacao>(); 
		List<Postograduacao> list = ServiceGlobalSession.findAllPostoGraduacao();
		if(query.length()>=3){
			for(Postograduacao p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	} 
	
	
	public List<Quadro> autoCompleteQuadro(String query) {  

		List<Quadro> suggestions = new ArrayList<Quadro>(); 
		List<Quadro> list = ServiceGlobalSession.findAllQuadro();
		if(query.length()>=3){
			for(Quadro p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	} 
	
	public List<Notaanomala> autoCompleteNotaAnomala(String query) {  

		List<Notaanomala> suggestions = new ArrayList<Notaanomala>(); 
		List<Notaanomala> list = ServiceGlobalSession.findAllNotaAnomala();
		if(query.length()>=3){
			for(Notaanomala p : list) {  
				if(p.getDescricao().toUpperCase().contains(query.toUpperCase()))  
					suggestions.add(p);  
			}  
		}else if(query.length()==0){
			suggestions = list;
		}

		return suggestions;  
	}  
}
