package br.gov.sspba.converter;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.sspba.domain.Barba;
import br.gov.sspba.domain.UserRole;
import br.gov.sspba.service.ServiceGlobalSession;



@FacesConverter("br.gov.sspba.converter.UserRoleConverter")
public class UserRoleConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		Long id = Long.parseLong(value);
		
		List<UserRole> regraList = ServiceGlobalSession.findAllUserRole();
		UserRole regra = new UserRole();
		regra.setId(id);
		if(regraList!=null){
			regra =regraList.get(regraList.indexOf(regra));
		}else{
			regra=UserRole.findUserRole(id);
		}
			
		return regra;
		
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return  ((Long) value).toString();
	}

}
