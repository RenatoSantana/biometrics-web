package br.gov.sspba.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("upperCaseConverter")
public class UpperCaseConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		// TODO Auto-generated method stub
		  return value.toUpperCase();
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// TODO Auto-generated method stub
		  return value.toString();
	}  

}
