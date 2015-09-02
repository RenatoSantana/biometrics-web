package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Cabelo;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.CabeloConverter")
public class CabeloConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Cabelo> list = ServiceGlobalSession.findAllCabelo();
		Cabelo cabelo = new Cabelo();
		cabelo.setIdCabelo(id);
		if(list!=null){
			cabelo =list.get(list.indexOf(cabelo));
		}else{
			cabelo=Cabelo.findCabelo(id);
		}
			
		return cabelo;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
