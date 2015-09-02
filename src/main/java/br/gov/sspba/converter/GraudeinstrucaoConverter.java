package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Graudeinstrucao;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.GraudeinstrucaoConverter")
public class GraudeinstrucaoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Graudeinstrucao> grauList = ServiceGlobalSession.findAllGrauInstrucao();
		Graudeinstrucao grau = new Graudeinstrucao();
		grau.setIdGrauDeInstrucao(id);
		if(grauList!=null){
			grau =grauList.get(grauList.indexOf(grau));
		}else{
			grau=Graudeinstrucao.findGraudeinstrucao(id);
		}
			
		return grau;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
