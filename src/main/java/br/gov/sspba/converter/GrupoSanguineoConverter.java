package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Gruposanguineo;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.GrupoSanguineoConverter")
public class GrupoSanguineoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Integer id = Integer.parseInt(value);
		List<Gruposanguineo> grupoList = ServiceGlobalSession.findAllGrupoSanguineo();
		Gruposanguineo grupo = new Gruposanguineo();
		grupo.setIdGrupoSanguineo(id);
		if(grupoList!=null){
			grupo =grupoList.get(grupoList.indexOf(grupo));
		}else{
			grupo=Gruposanguineo.findGruposanguineo(id);
		}
			
		return grupo;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Integer) value).toString();
	}

}
