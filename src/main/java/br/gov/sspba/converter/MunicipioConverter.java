package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Municipio;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.MunicipioConverter")
public class MunicipioConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Municipio> municipioList = ServiceGlobalSession.findAllMunicipio();
		Municipio municipio = new Municipio();
		municipio.setIdMunicipio(id);
		if(municipioList!=null){
			municipio =municipioList.get(municipioList.indexOf(municipio));
		}else{
			municipio=Municipio.findMunicipio(id);
		}
			
		return municipio;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
