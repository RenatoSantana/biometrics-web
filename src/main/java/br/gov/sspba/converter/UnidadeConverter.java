package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Unidade;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.UnidadeConverter")
public class UnidadeConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Unidade> unidadeList = ServiceGlobalSession.findAllUnidade();
		Unidade unidade = new Unidade();
		unidade.setIdUnidade(id);
		if(unidadeList!=null){
			unidade =unidadeList.get(unidadeList.indexOf(unidade));
		}else{
			unidade=Unidade.findUnidade(id);
		}
			
		return unidade;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
