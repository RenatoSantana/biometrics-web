package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Postograduacao;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.PostoGraduacaoConverter")
public class PostoGraduacaoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Postograduacao> postoList = ServiceGlobalSession.findAllPostoGraduacao();
		Postograduacao posto = new Postograduacao();
		posto.setIdPostoGraduacao(id);
		if(postoList!=null){
			posto =postoList.get(postoList.indexOf(posto));
		}else{
			posto=Postograduacao.findPostograduacao(id);
		}
			
		return posto;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
