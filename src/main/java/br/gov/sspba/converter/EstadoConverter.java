package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Estado;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.EstadoConverter")
public class EstadoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
	    Integer id = Integer.parseInt(value);
		
		List<Estado> estadoList = ServiceGlobalSession.findAllEstado();
		Estado estado = new Estado();
		estado.setIdEstado(id);
		if(estadoList!=null){
			estado =estadoList.get(estadoList.indexOf(estado));
		}else{
			estado=Estado.findEstado(id);
		}
			
		return estado;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
