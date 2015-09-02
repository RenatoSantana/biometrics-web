package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Fatorrh;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.FatorRHConverter")
public class FatorRHConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Fatorrh> fatorList = ServiceGlobalSession.findAllFatorRH();
		Fatorrh fator = new Fatorrh();
		fator.setIdFatorRh(id);
		if(fatorList!=null){
			fator =fatorList.get(fatorList.indexOf(fator));
		}else{
			fator=Fatorrh.findFatorrh(id);
		}
			
		return fator;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
