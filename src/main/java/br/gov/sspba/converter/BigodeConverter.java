package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Bigode;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.BigodeConverter")
public class BigodeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Bigode> list = ServiceGlobalSession.findAllBigode();
		Bigode bigode = new Bigode();
		bigode.setIdBigode(id);
		if(list!=null){
			bigode =list.get(list.indexOf(bigode));
		}else{
			bigode=Bigode.findBigode(id);
		}
			
		return bigode;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
