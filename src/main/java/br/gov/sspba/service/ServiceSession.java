package br.gov.sspba.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.sspba.domain.Bairro;
import br.gov.sspba.domain.Estado;
import br.gov.sspba.domain.Municipio;

@Component
@Scope(value = "session")
public class ServiceSession {

	
	private static List<Municipio> municipioList;
	
	private static List<Bairro> bairroList;

	
	
	public static List<Bairro> findAllBairroByMunicipio(Municipio municipio){

		if(bairroList==null){
			    return bairroList = Bairro.findBairroesByIdMunicipio(municipio).getResultList();
		}else{
			    Bairro bairro = bairroList.get(0);
				if(bairro.getIdMunicipio().getIdMunicipio() == municipio.getIdMunicipio()){
					return bairroList;
				}else{
					return bairroList = Bairro.findBairroesByIdMunicipio(municipio).getResultList();
				}
			
		}
			

	}
	
	public static List<Municipio> findAllMunicipiosByEstado(Estado estado){

		if(municipioList==null){
			    return municipioList = Municipio.findMunicipiosByIdEstadoEquals(estado).getResultList();
		}else{
			   Municipio municipio = municipioList.get(0);
				if(municipio.getIdEstado().getIdEstado() == estado.getIdEstado()){
					return municipioList;
				}else{
					return municipioList = Municipio.findMunicipiosByIdEstadoEquals(estado).getResultList();
				}
		
		}
			

	}
	
	
	public static List<Municipio> getMunicipioList() {
		return municipioList;
	}

	public static void setMunicipioList(List<Municipio> municipioList) {
		ServiceSession.municipioList = municipioList;
	}
}
