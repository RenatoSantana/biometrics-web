package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Barba;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.BarbaConverter")
public class BarbaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		
		List<Barba> barbaList = ServiceGlobalSession.findAllBarba();
		Barba barba = new Barba();
		barba.setIdBarba(id);
		if(barbaList!=null){
			barba =barbaList.get(barbaList.indexOf(barba));
		}else{
			barba=Barba.findBarba(id);
		}
			
		return barba;
		
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
