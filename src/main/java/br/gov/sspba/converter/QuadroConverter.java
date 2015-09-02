package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Quadro;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.QuadroConverter")
public class QuadroConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Quadro> quadroList = ServiceGlobalSession.findAllQuadro();
		Quadro quadro = new Quadro();
		quadro.setIdQuadro(id);
		if(quadroList!=null){
			quadro =quadroList.get(quadroList.indexOf(quadro));
		}else{
			quadro=Quadro.findQuadro(id);
		}
			
		return quadro;
		
		
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
