package br.gov.sspba.converter;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("br.gov.sspba.converter.CriptografiaSHA256")
public class CriptografiaSHA256 implements Converter{

	
	  @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      
	        if(value.equalsIgnoreCase(""))
	            return "";
	        else if (value.length()<1){
	            FacesContext.getCurrentInstance().addMessage("newPassword", new FacesMessage("Senha não pode ser inferior a 1 caracters!"));
	            return value;
	        }
	        
	        try {
	            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = messageDigest.digest(value.getBytes("UTF-8"));
	            StringBuilder stringBuilder=  new StringBuilder();
	            for (int i = 0; i < hash.length; i++) {
	                stringBuilder.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            return stringBuilder.toString();
	        } catch (NoSuchAlgorithmException ex) {
	            Logger.getLogger(CriptografiaSHA256.class.getName()).log(Level.SEVERE, null, ex);
	            return "";
	        } catch (UnsupportedEncodingException unsupportedEncodingException) {
	            Logger.getLogger(CriptografiaSHA256.class.getName()).log(Level.SEVERE, null,"CriptografiaSHA256.getAsObject:"+ unsupportedEncodingException);
	            return "";
	        }
	    }

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object value) {
	        return "";
	    }
	    
	    
	    
}
