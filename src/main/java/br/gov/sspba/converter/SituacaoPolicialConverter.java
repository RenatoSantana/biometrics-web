package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Situacaopolicial;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.SituacaoPolicialConverter")
public class SituacaoPolicialConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Situacaopolicial> situacaoList = ServiceGlobalSession.findAllSituacaoPolicial();
		Situacaopolicial situacao = new Situacaopolicial();
		situacao.setIdSituacaoPolicial(id);
		if(situacaoList!=null){
			situacao =situacaoList.get(situacaoList.indexOf(situacao));
		}else{
			situacao=Situacaopolicial.findSituacaopolicial(id);
		}
			
		return situacao;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Situacaopolicial) value).toString();
	}

}
