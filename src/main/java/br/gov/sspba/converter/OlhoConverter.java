package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Olho;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.OlhoConverter")
public class OlhoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Olho> olhoList = ServiceGlobalSession.findAllOlho();
		Olho olho = new Olho();
		olho.setIdOlho(id);
		if(olhoList!=null){
			olho =olhoList.get(olhoList.indexOf(olho));
		}else{
			olho=Olho.findOlho(id);
		}
			
		return olho;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
