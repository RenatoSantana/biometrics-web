package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Sexo;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.SexoConverter")
public class SexoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Sexo> sexoList = ServiceGlobalSession.findAllSexo();
		Sexo sexo = new Sexo();
		sexo.setIdSexo(id);
		if(sexoList!=null){
			sexo =sexoList.get(sexoList.indexOf(sexo));
		}else{
			sexo=Sexo.findSexo(id);
		}
			
		return sexo;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Sexo) value).toString();
	}

}
