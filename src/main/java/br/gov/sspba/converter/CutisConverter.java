package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Cutis;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.CutisConverter")
public class CutisConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Cutis> list = ServiceGlobalSession.findAllCutis();
		Cutis cutis = new Cutis();
		cutis.setIdCutis(id);
		if(list!=null){
			cutis =list.get(list.indexOf(cutis));
		}else{
			cutis=Cutis.findCutis(id);
		}
			
		return cutis;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
