package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Estadocivil;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.EstadoCivilConverter")
public class EstadoCivilConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Estadocivil> list = ServiceGlobalSession.findAllEstadoCivil();
		Estadocivil estadoCivil = new Estadocivil();
		estadoCivil.setIdEstadoCivil(id);
		if(list!=null){
			estadoCivil =list.get(list.indexOf(estadoCivil));
		}else{
			estadoCivil=Estadocivil.findEstadocivil(id);
		}
			
		return estadoCivil;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
