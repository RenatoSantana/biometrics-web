package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Tipocertidao;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.TipoCertidaoConverter")
public class TipoCertidaoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Tipocertidao> certidaoList = ServiceGlobalSession.findAllTipoCertidao();
		Tipocertidao certidao = new Tipocertidao();
		certidao.setIdTipoCertidao(id);
		if(certidaoList!=null){
			certidao =certidaoList.get(certidaoList.indexOf(certidao));
		}else{
			certidao=Tipocertidao.findTipocertidao(id);
		}
			
		return certidao;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
