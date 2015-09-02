package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Notaanomala;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.NotaAnomalaConverter")
public class NotaAnomalaConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Notaanomala> notaList = ServiceGlobalSession.findAllNotaAnomala();
		Notaanomala nota = new Notaanomala();
		nota.setIdNotaAnomala(id);
		if(notaList!=null){
			nota =notaList.get(notaList.indexOf(nota));
		}else{
			nota=Notaanomala.findNotaanomala(id);
		}
			
		return nota;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
